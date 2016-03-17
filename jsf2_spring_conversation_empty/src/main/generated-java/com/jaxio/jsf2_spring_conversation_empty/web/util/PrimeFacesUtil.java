/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-jsf2-spring-conversation:src/main/java/util/PrimeFacesUtil.p.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/pack-jsf2-spring-conversation
 */
package com.jaxio.jsf2_spring_conversation_empty.web.util;

import javax.servlet.http.HttpServletRequest;

import org.primefaces.context.RequestContext;

/**
 * Use this bean to execute JavaScript on client side.
 */
public final class PrimeFacesUtil {

    private PrimeFacesUtil() {
    }

    /**
     * Tells the client to update the search results region with the passed text.
     */
    public static void updateSearchResultsRegion(String text, int nbResults) {
        if (RequestContext.getCurrentInstance() != null) {
            RequestContext.getCurrentInstance().execute("APP.updateSearchResultsRegion(\"" + text + "\"," + nbResults + ")");
        }
    }

    public static boolean isAjax(HttpServletRequest request) {
        return "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
    }

    public static void forceClose() {
        RequestContext.getCurrentInstance().execute("APP.menu.forceClose()");
    }
}
