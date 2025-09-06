# Ensure gold is completely disabled
EXTRA_OECONF:remove = "--enable-gold"
EXTRA_OECONF:append = " --disable-gold --disable-gold-dfa"

