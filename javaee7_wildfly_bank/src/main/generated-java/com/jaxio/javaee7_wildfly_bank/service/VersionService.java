/*
 * Source code generated by Celerio, a Jaxio product.
 * Documentation: http://www.jaxio.com/documentation/celerio/
 * Follow us on twitter: @jaxiosoft
 * Need commercial support ? Contact us: info@jaxio.com
 * Template pack-javaee7-backend:src/main/java/service/VersionService.p.vm.java
 * Template is part of Open Source Project: https://github.com/jaxio/javaee-lab
 */
package com.jaxio.javaee7_wildfly_bank.service;

import static org.apache.commons.lang.StringUtils.endsWithIgnoreCase;
import static org.apache.commons.lang.StringUtils.equalsIgnoreCase;

import javax.inject.Named;

@Named
public class VersionService {

    private static final String NO_SVN_REVISION = "noSVNRevision";

    //@Value("${build.version:}")
    private String version = "1.0.0-SNAPSHOT"; // TODO

    //@Value("${build.svnrevision:}")
    private String svnrevision = "0"; // TODO

    public String format() {
        if (endsWithIgnoreCase(version, "SNAPSHOT") && !equalsIgnoreCase(svnrevision, NO_SVN_REVISION)) {
            return version + " (rev" + svnrevision + ")";
        }
        return version;
    }

    public String getVersion() {
        return version;
    }

    public String getSvnrevision() {
        return svnrevision;
    }
}
