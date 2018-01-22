<?xml version="1.0" encoding="gb2312" ?> 
<xsl:stylesheet xmlns:xsl="http://www.w3.org/TR/WD-xsl" 
xmlns="http://www.w3.org/TR/REC-html40"> 
<xsl:template> 
<xsl:apply-templates/> 
</xsl:template> 
  
<xsl:template match="/"> 
<HTML> 
<HEAD> 
<TITLE>Эͬ��ϵ��</TITLE> 
<STYLE> 
CAPTION{font-size:15pt; font-weight:bold; color:blue } 
</STYLE> 
</HEAD> 
<BODY> 
<xsl:apply-templates select="CollaborationReport"/> 
</BODY> 
</HTML> 
</xsl:template> 
<xsl:template match="CollaborationReport"> 
<!--Эͬ��ϵ������  begin-->
<TABLE BORDER="1" align="center"> 
<xsl:for-each select="WholeReport"> 
<CAPTION>Эͬ��ϵ��</CAPTION> 
<THEAD> 
<TD> <B>�� �� �� ��</B> </TD> 
<TD> <B>�� ɫ</B> </TD> 
<TD> <B>�� �� �� ��</B> </TD> 
<TD> <B>�� �� �� ��</B> </TD>
<TD> <B>�� ֯ �� ��</B> </TD>
</THEAD> 
<xsl:for-each select="ColData"> 
<TR> 
<TD align="left"><xsl:value-of select="Act"/></TD> 
<TD align="left"><xsl:value-of select="Roles"/></TD> 
<TD align="left"><xsl:value-of select="MachineTypes"/></TD>
<TD align="left"><xsl:value-of select="LocationTypes"/></TD> 
<TD align="left"><xsl:value-of select="ResourceGroups"/></TD> 
</TR> 
</xsl:for-each>
</xsl:for-each> 
</TABLE> 
<!--Эͬ��ϵ������  end-->

</xsl:template>
</xsl:stylesheet> 