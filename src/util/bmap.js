!(function (t, e) { typeof exports === 'object' && typeof module !== 'undefined' ? e(exports, require('echarts')) : typeof define === 'function' && define.amd ? define(['exports', 'echarts'], e) : e(t.bmap = {}, t.echarts) }(this, (t, e) => {
  function o(t, e) { this._bmap = t, this.dimensions = ['lng', 'lat'], this._mapOffset = [0, 0], this._api = e, this._projection = new BMap.MercatorProjection() } function n(t, o) {
    return o = o || [0, 0], e.util.map([0, 1], function (e) {
      let n = o[e],
        i = t[e] / 2,
        a = [],
        r = []; return a[e] = n - i, r[e] = n + i, a[1 - e] = r[1 - e] = o[1 - e], Math.abs(this.dataToPoint(a)[e] - this.dataToPoint(r)[e])
    }, this)
  } function i() { function t(t) { this._root = t } return t.prototype = new BMap.Overlay(), t.prototype.initialize = function (t) { return t.getPanes().labelPane.appendChild(this._root), this._root }, t.prototype.draw = function () { }, t } function a(t, e) { return t && e && t[0] === e[0] && t[1] === e[1] } o.prototype.dimensions = ['lng', 'lat'], o.prototype.setZoom = function (t) { this._zoom = t }, o.prototype.setCenter = function (t) { this._center = this._projection.lngLatToPoint(new BMap.Point(t[0], t[1])) }, o.prototype.setMapOffset = function (t) { this._mapOffset = t }, o.prototype.getBMap = function () { return this._bmap }, o.prototype.dataToPoint = function (t) {
    let e = new BMap.Point(t[0], t[1]),
      o = this._bmap.pointToOverlayPixel(e),
      n = this._mapOffset; return [o.x - n[0], o.y - n[1]]
  }, o.prototype.pointToData = function (t) { const e = this._mapOffset; return [(t = this._bmap.overlayPixelToPoint({ x: t[0] + e[0], y: t[1] + e[1] })).lng, t.lat] }, o.prototype.getViewRect = function () { const t = this._api; return new e.graphic.BoundingRect(0, 0, t.getWidth(), t.getHeight()) }, o.prototype.getRoamTransform = function () { return e.matrix.create() }, o.prototype.prepareCustoms = function (t) { const o = this.getViewRect(); return { coordSys: { type: 'bmap', x: o.x, y: o.y, width: o.width, height: o.height }, api: { coord: e.util.bind(this.dataToPoint, this), size: e.util.bind(n, this) } } }; let r; o.dimensions = o.prototype.dimensions, o.create = function (t, e) {
    let n,
      a = e.getDom(); t.eachComponent('bmap', (t) => {
        let p = e.getZr().painter,
          s = p.getViewportRoot(); if (typeof BMap === 'undefined') throw new Error('BMap api is not loaded'); if (r = r || i(), n) throw new Error('Only one bmap component can exist'); if (!t.__bmap) {
            let m = a.querySelector('.ec-extension-bmap'); m && (s.style.left = '0px', s.style.top = '0px', a.removeChild(m)), (m = document.createElement('div')).style.cssText = 'width:100%;height:100%', m.classList.add('ec-extension-bmap'), a.appendChild(m); var c = t.__bmap = new BMap.Map(m),
              d = new r(s); c.addOverlay(d), p.getViewportRootOffset = function () { return { offsetLeft: 0, offsetTop: 0 } }
          } var c = t.__bmap,
            f = t.get('center'),
            l = t.get('zoom'); if (f && l) { const h = new BMap.Point(f[0], f[1]); c.centerAndZoom(h, l) } (n = new o(c, e)).setMapOffset(t.__mapOffset || [0, 0]), n.setZoom(l), n.setCenter(f), t.coordinateSystem = n
      }), t.eachSeries((t) => { t.get('coordinateSystem') === 'bmap' && (t.coordinateSystem = n) })
  }, e.extendComponentModel({ type: 'bmap', getBMap() { return this.__bmap }, setCenterAndZoom(t, e) { this.option.center = t, this.option.zoom = e }, centerOrZoomChanged(t, e) { const o = this.option; return !(a(t, o.center) && e === o.zoom) }, defaultOption: { center: [104.114129, 37.550339], zoom: 5, mapStyle: {}, roam: !1 } }), e.extendComponentView({
    type: 'bmap',
    render(t, e, o) {
      function n() { i || o.dispatchAction({ type: 'bmapRoam' }) } var i = !0,
        a = t.getBMap(),
        r = o.getZr().painter.getViewportRoot(),
        p = t.coordinateSystem,
        s = function (e, n) {
          if (!i) {
            let a = r.parentNode.parentNode.parentNode,
              s = [-parseInt(a.style.left, 10) || 0, -parseInt(a.style.top, 10) || 0]; r.style.left = `${s[0]}px`, r.style.top = `${s[1]}px`, p.setMapOffset(s), t.__mapOffset = s, o.dispatchAction({ type: 'bmapRoam' })
          }
        }; a.removeEventListener('moving', this._oldMoveHandler), a.removeEventListener('zoomend', this._oldZoomEndHandler), a.addEventListener('moving', s), a.addEventListener('zoomend', n), this._oldMoveHandler = s, this._oldZoomEndHandler = n; const m = t.get('roam'); m && m !== 'scale' ? a.enableDragging() : a.disableDragging(), m && m !== 'move' ? (a.enableScrollWheelZoom(), a.enableDoubleClickZoom(), a.enablePinchToZoom()) : (a.disableScrollWheelZoom(), a.disableDoubleClickZoom(), a.disablePinchToZoom()); let c = t.__mapStyle,
          d = t.get('mapStyle') || {},
          f = JSON.stringify(d); JSON.stringify(c) !== f && (Object.keys(d).length && a.setMapStyle(d), t.__mapStyle = JSON.parse(f)), i = !1
    },
  }), e.registerCoordinateSystem('bmap', o), e.registerAction({ type: 'bmapRoam', event: 'bmapRoam', update: 'updateLayout' }, (t, e) => {
    e.eachComponent('bmap', (t) => {
      let e = t.getBMap(),
        o = e.getCenter(); t.setCenterAndZoom([o.lng, o.lat], e.getZoom())
    })
  }); t.version = '1.0.0'
}))
