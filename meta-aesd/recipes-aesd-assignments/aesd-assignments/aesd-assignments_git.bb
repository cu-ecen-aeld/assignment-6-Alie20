# License
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

# Source repository
SRC_URI = "git://github.com/cu-ecen-aeld/assignments-3-and-later-Alie20.git;protocol=ssh;branch=main"
PV = "1.0+git${SRCPV}"
SRCREV = "748d59308b60d275218b358056ca52d35707f29a"

# Build directory
S = "${WORKDIR}/git/server"

# Install target files
FILES:${PN} += "${bindir}/aesdsocket"

# init script
inherit update-rc.d
INITSCRIPT_PACKAGES = "${PN}"
INITSCRIPT_NAME:${PN} = "aesdsocket-start-stop"

# Add LDFLAGS in proper BitBake way
TARGET_LDFLAGS += "-pthread -lrt"


do_configure () {
    :
}

do_compile () {
    oe_runmake LDFLAGS="${TARGET_LDFLAGS}"
}

do_install () {
    install -d ${D}${bindir}
    install -d ${D}${sysconfdir}/init.d

    install -m 0755 ${S}/aesdsocket ${D}${bindir}/
    install -m 0755 ${S}/aesdsocket-start-stop ${D}${sysconfdir}/init.d/
}

