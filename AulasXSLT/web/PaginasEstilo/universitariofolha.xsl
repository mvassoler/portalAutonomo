<?xml version="1.0" encoding="UTF-8"?>

<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>
    <xsl:template match="faculdade">
        <html>            
            <body>
                <p>Idendificador : <xsl:value-of select="aluno/@identificador"/></p>
                <p style="color:red;">Nome : <xsl:value-of select="aluno/nome"/></p>
                <p>Idade : <xsl:value-of select="aluno/idade"/></p>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
