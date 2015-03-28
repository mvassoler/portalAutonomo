<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>
    <xsl:template match="livro">
        <html>
            <head>
                <title>
                    ISBN <xsl:value-of select="@isbn"/> - <xsl:value-of select="titulo"/>                
                </title>
            </head>
            <body style="background-color:lightgreen">
                <h1><xsl:value-of select="titulo"/></h1>
                <h2>
                    Por <xsl:value-of select="autor/sobrenome"/>, <xsl:value-of select="autor/nome"/> 
                </h2>
                <table border = "1">
                    <xsl:for-each select="capitulos/capitulo">
                        <xsl:sort select="@numero" order="ascending"/>
                        <tr>
                            <td align="right">Capitulo <xsl:value-of select="@numero"/></td>
                            <td>
                                <xsl:value-of select="self::node()"/>
                                (<xsl:value-of select="@paginas"/> paǵinas )
                            </td>
                        </tr>                        
                    </xsl:for-each>                    
                </table>
                Midia <xsl:value-of select="midia/@tipo"/>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
