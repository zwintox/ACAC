/*! modernizr 3.6.0 (Custom Build) | MIT *
 * https://modernizr.com/download/?-capture-directory-fileinput-formattribute-input-inputformaction-inputformenctype-inputformmethod-inputformtarget-inputtypes-localizednumber-oninput-search-setclasses !*/
!function (e, t, n) {
    function i(e, t) {
        return typeof e === t
    }

    function r() {
        var e, t, n, r, a, o, s;
        for (var d in u) if (u.hasOwnProperty(d)) {
            if (e = [], t = u[d], t.name && (e.push(t.name.toLowerCase()), t.options && t.options.aliases && t.options.aliases.length)) for (n = 0; n < t.options.aliases.length; n++) e.push(t.options.aliases[n].toLowerCase());
            for (r = i(t.fn, "function") ? t.fn() : t.fn, a = 0; a < e.length; a++) o = e[a], s = o.split("."), 1 === s.length ? Modernizr[s[0]] = r : (!Modernizr[s[0]] || Modernizr[s[0]] instanceof Boolean || (Modernizr[s[0]] = new Boolean(Modernizr[s[0]])), Modernizr[s[0]][s[1]] = r), l.push((r ? "" : "no-") + s.join("-"))
        }
    }

    function a(e) {
        var t = f.className, n = Modernizr._config.classPrefix || "";
        if (c && (t = t.baseVal), Modernizr._config.enableJSClass) {
            var i = new RegExp("(^|\\s)" + n + "no-js(\\s|$)");
            t = t.replace(i, "$1" + n + "js$2")
        }
        Modernizr._config.enableClasses && (t += " " + n + e.join(" " + n), c ? f.className.baseVal = t : f.className = t)
    }

    function o() {
        return "function" != typeof t.createElement ? t.createElement(arguments[0]) : c ? t.createElementNS.call(t, "http://www.w3.org/2000/svg", arguments[0]) : t.createElement.apply(t, arguments)
    }

    function s() {
        var e = t.body;
        return e || (e = o(c ? "svg" : "body"), e.fake = !0), e
    }

    function d(e, n, i, r) {
        var a, d, l, u, p = "modernizr", c = o("div"), m = s();
        if (parseInt(i, 10)) for (; i--;) l = o("div"), l.id = r ? r[i] : p + (i + 1), c.appendChild(l);
        return a = o("style"), a.type = "text/css", a.id = "s" + p, (m.fake ? m : c).appendChild(a), m.appendChild(c), a.styleSheet ? a.styleSheet.cssText = e : a.appendChild(t.createTextNode(e)), c.id = p, m.fake && (m.style.background = "", m.style.overflow = "hidden", u = f.style.overflow, f.style.overflow = "hidden", f.appendChild(m)), d = n(c, e), m.fake ? (m.parentNode.removeChild(m), f.style.overflow = u, f.offsetHeight) : c.parentNode.removeChild(c), !!d
    }

    var l = [], u = [], p = {
        _version: "3.6.0",
        _config: {classPrefix: "", enableClasses: !0, enableJSClass: !0, usePrefixes: !0},
        _q: [],
        on: function (e, t) {
            var n = this;
            setTimeout(function () {
                t(n[e])
            }, 0)
        },
        addTest: function (e, t, n) {
            u.push({name: e, fn: t, options: n})
        },
        addAsyncTest: function (e) {
            u.push({name: null, fn: e})
        }
    }, Modernizr = function () {
    };
    Modernizr.prototype = p, Modernizr = new Modernizr;
    var f = t.documentElement, c = "svg" === f.nodeName.toLowerCase();
    Modernizr.addTest("capture", "capture" in o("input")), Modernizr.addTest("fileinput", function () {
        if (navigator.userAgent.match(/(Android (1.0|1.1|1.5|1.6|2.0|2.1))|(Windows Phone (OS 7|8.0))|(XBLWP)|(ZuneWP)|(w(eb)?OSBrowser)|(webOS)|(Kindle\/(1.0|2.0|2.5|3.0))/)) return !1;
        var e = o("input");
        return e.type = "file", !e.disabled
    }), Modernizr.addTest("formattribute", function () {
        var e, n = o("form"), i = o("input"), r = o("div"), a = "formtest" + (new Date).getTime(), s = !1;
        n.id = a;
        try {
            i.setAttribute("form", a)
        } catch (d) {
            t.createAttribute && (e = t.createAttribute("form"), e.nodeValue = a, i.setAttributeNode(e))
        }
        return r.appendChild(n), r.appendChild(i), f.appendChild(r), s = n.elements && 1 === n.elements.length && i.form == n, r.parentNode.removeChild(r), s
    }), Modernizr.addTest("inputformaction", !!("formAction" in o("input")), {aliases: ["input-formaction"]}), Modernizr.addTest("inputformenctype", !!("formEnctype" in o("input")), {aliases: ["input-formenctype"]}), Modernizr.addTest("inputformmethod", !!("formMethod" in o("input"))), Modernizr.addTest("inputformtarget", !!("formtarget" in o("input")), {aliases: ["input-formtarget"]});
    var m = o("input"), v = "autocomplete autofocus list placeholder max min multiple pattern required step".split(" "),
        h = {};
    Modernizr.input = function (t) {
        for (var n = 0, i = t.length; i > n; n++) h[t[n]] = !!(t[n] in m);
        return h.list && (h.list = !(!o("datalist") || !e.HTMLDataListElement)), h
    }(v);
    var y = "search tel url email datetime date month week time datetime-local number range color".split(" "), g = {};
    Modernizr.inputtypes = function (e) {
        for (var i, r, a, o = e.length, s = "1)", d = 0; o > d; d++) m.setAttribute("type", i = e[d]), a = "text" !== m.type && "style" in m, a && (m.value = s, m.style.cssText = "position:absolute;visibility:hidden;", /^range$/.test(i) && m.style.WebkitAppearance !== n ? (f.appendChild(m), r = t.defaultView, a = r.getComputedStyle && "textfield" !== r.getComputedStyle(m, null).WebkitAppearance && 0 !== m.offsetHeight, f.removeChild(m)) : /^(search|tel)$/.test(i) || (a = /^(url|email)$/.test(i) ? m.checkValidity && m.checkValidity() === !1 : m.value != s)), g[e[d]] = !!a;
        return g
    }(y);
    var b = function () {
        function e(e, t) {
            var r;
            return e ? (t && "string" != typeof t || (t = o(t || "div")), e = "on" + e, r = e in t, !r && i && (t.setAttribute || (t = o("div")), t.setAttribute(e, ""), r = "function" == typeof t[e], t[e] !== n && (t[e] = n), t.removeAttribute(e)), r) : !1
        }

        var i = !("onblur" in t.documentElement);
        return e
    }();
    p.hasEvent = b, Modernizr.addTest("inputsearchevent", b("search"));
    var C = "Moz O ms Webkit", T = p._config.usePrefixes ? C.toLowerCase().split(" ") : [];
    p._domPrefixes = T, Modernizr.addTest("fileinputdirectory", function () {
        var e = o("input"), t = "directory";
        if (e.type = "file", t in e) return !0;
        for (var n = 0, i = T.length; i > n; n++) if (T[n] + t in e) return !0;
        return !1
    });
    var w = p.testStyles = d;
    Modernizr.addTest("oninput", function () {
        var n, i = o("input");
        if (i.setAttribute("oninput", "return"), b("oninput", f) || "function" == typeof i.oninput) return !0;
        try {
            var r = t.createEvent("KeyboardEvent");
            n = !1;
            var a = function (e) {
                n = !0, e.preventDefault(), e.stopPropagation()
            };
            r.initKeyEvent("keypress", !0, !0, e, !1, !1, !1, !1, 0, "e".charCodeAt(0)), f.appendChild(i), i.addEventListener("input", a, !1), i.focus(), i.dispatchEvent(r), i.removeEventListener("input", a, !1), f.removeChild(i)
        } catch (s) {
            n = !1
        }
        return n
    }), Modernizr.addTest("formvalidation", function () {
        var t = o("form");
        if (!("checkValidity" in t && "addEventListener" in t)) return !1;
        if ("reportValidity" in t) return !0;
        var n, i = !1;
        return Modernizr.formvalidationapi = !0, t.addEventListener("submit", function (t) {
            (!e.opera || e.operamini) && t.preventDefault(), t.stopPropagation()
        }, !1), t.innerHTML = '<input name="modTest" required="required" /><button></button>', w("#modernizr form{position:absolute;top:-99999em}", function (e) {
            e.appendChild(t), n = t.getElementsByTagName("input")[0], n.addEventListener("invalid", function (e) {
                i = !0, e.preventDefault(), e.stopPropagation()
            }, !1), Modernizr.formvalidationmessage = !!n.validationMessage, t.getElementsByTagName("button")[0].click()
        }), i
    }), Modernizr.addTest("localizednumber", function () {
        if (!Modernizr.inputtypes.number) return !1;
        if (!Modernizr.formvalidation) return !1;
        var e, n = o("div"), i = s(), r = function () {
            return f.insertBefore(i, f.firstElementChild || f.firstChild)
        }();
        n.innerHTML = '<input type="number" value="1.0" step="0.1"/>';
        var a = n.childNodes[0];
        r.appendChild(n), a.focus();
        try {
            t.execCommand("SelectAll", !1), t.execCommand("InsertText", !1, "1,1")
        } catch (d) {
        }
        return e = "number" === a.type && 1.1 === a.valueAsNumber && a.checkValidity(), r.removeChild(n), i.fake && r.parentNode.removeChild(r), e
    }), r(), a(l), delete p.addTest, delete p.addAsyncTest;
    for (var E = 0; E < Modernizr._q.length; E++) Modernizr._q[E]();
    e.Modernizr = Modernizr
}(window, document);