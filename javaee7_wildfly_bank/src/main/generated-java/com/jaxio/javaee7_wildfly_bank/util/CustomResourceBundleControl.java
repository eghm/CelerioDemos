/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-javaee7-backend:src/main/java/util/CustomResourceBundleControl.p.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/javaee-lab
 */
package com.jaxio.javaee7_wildfly_bank.util;

import static com.google.common.collect.Lists.newArrayList;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

import org.apache.commons.io.IOUtils;

/**
 * <ul>
 * <li>handles properties files encoded in UTF-8</li>
 * <li>handles properties in xml files</li>
 * <li>set fallback locale to ROOT instead of default locale</li>
 * </ul>
 */
public class CustomResourceBundleControl extends ResourceBundle.Control {

    private static final String ENCODING = "UTF-8";
    protected static final String BUNDLE_EXTENSION = "xml";

    @Override
    public List<String> getFormats(String baseName) {
        List<String> formats = newArrayList(super.getFormats(baseName));
        formats.add(BUNDLE_EXTENSION);
        return formats;
    }

    @Override
    public Locale getFallbackLocale(String baseName, Locale locale) {
        return !Locale.ROOT.equals(locale) ? Locale.ROOT : null;
    }

    @Override
    public ResourceBundle newBundle(String baseName, Locale locale, String format, ClassLoader loader, boolean reload) throws IllegalAccessException,
            InstantiationException, IOException {
        if ("java.properties".equals(format)) {
            return newBundleInProperties(baseName, locale, loader, reload);
        } else if (BUNDLE_EXTENSION.equals(format)) {
            return newBundleInXml(baseName, locale, loader, reload);
        } else {
            return super.newBundle(baseName, locale, format, loader, reload);
        }
    }

    public ResourceBundle newBundleInXml(String baseName, Locale locale, ClassLoader loader, boolean reload) throws IllegalAccessException,
            InstantiationException, IOException {
        String bundleName = toBundleName(baseName, locale);
        String resourceName = toResourceName(bundleName, BUNDLE_EXTENSION);
        InputStream stream = loadResourceAsStream(loader, reload, resourceName);
        if (stream == null) {
            return null;
        }
        BufferedInputStream bis = null;
        try {
            bis = new BufferedInputStream(stream);
            return new XmlResourceBundle(bis);
        } finally {
            IOUtils.closeQuietly(bis);
        }
    }

    private InputStream loadResourceAsStream(ClassLoader loader, boolean reload, String resourceName) throws IOException {
        if (!reload) {
            return loader.getResourceAsStream(resourceName);
        } else {
            URL url = loader.getResource(resourceName);
            if (url == null) {
                return null;
            }
            URLConnection connection = url.openConnection();
            if (connection == null) {
                throw new IllegalArgumentException(resourceName + " could not be opened");
            }
            connection.setUseCaches(false);
            return connection.getInputStream();
        }
    }

    public ResourceBundle newBundleInProperties(String baseName, Locale locale, ClassLoader loader, boolean reload) throws IllegalAccessException,
            InstantiationException, IOException {
        String bundleName = toBundleName(baseName, locale);
        final String resourceName = toResourceName(bundleName, "properties");
        final ClassLoader classLoader = loader;
        final boolean reloadFlag = reload;
        InputStream stream = loadResourceAsStream(classLoader, reloadFlag, resourceName);
        if (stream == null) {
            return null;
        }
        try {
            return new PropertyResourceBundle(new InputStreamReader(stream, ENCODING));
        } finally {
            IOUtils.closeQuietly(stream);
        }
    }

    public class XmlResourceBundle extends ResourceBundle {
        private Properties props;

        XmlResourceBundle(InputStream stream) throws IOException {
            props = new Properties();
            props.loadFromXML(stream);
        }

        @Override
        protected Object handleGetObject(String key) {
            return props.getProperty(key);
        }

        @Override
        public Enumeration<String> getKeys() {
            return Collections.enumeration(props.stringPropertyNames());
        }
    }
}
