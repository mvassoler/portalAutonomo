<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>
    <xsl:template match="faculdade">
        <html>
            <head>
                <title>Alunos Faculdade</title>
            </head>
            <body>
                <table border = "1">
                    <xsl:for-each select="aluno">
                        <xsl:sort select="@identificador" order="ascending"/>
                        <tr>
                            <td align="left">Id = <xsl:value-of select="@identificador"/></td>
                            <td align="left">Nome = <xsl:value-of select="nome"/></td>
                            <td align="left">Idade = <xsl:value-of select="idade"/></td>
                        </tr>                        
                    </xsl:for-each>                    
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
