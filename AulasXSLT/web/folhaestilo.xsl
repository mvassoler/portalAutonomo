<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>
    <xsl:template match="minhamensagem">
        <html>
            <head>
                <title>folhaestilo.xsl</title>
            </head>
            <body style="background-color-lightblue">
                <h2>
                    <strong>
                        <xsl:value-of select="mensagem"/>
                    </strong>
                </h2>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>