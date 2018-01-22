<?xml version="1.0" encoding="gb2312" ?> 
<xsl:stylesheet xmlns:xsl="http://www.w3.org/TR/WD-xsl" 
xmlns="http://www.w3.org/TR/REC-html40"> 
<xsl:template> 
<xsl:apply-templates/> 
</xsl:template> 
  
<xsl:template match="/"> 
<HTML> 
<HEAD> 
<TITLE>����ģ�ⱨ��</TITLE> 
<STYLE> 
CAPTION{font-size:15pt; font-weight:bold; color:blue } 
</STYLE> 
</HEAD> 
<BODY> 
<xsl:apply-templates select="SimulationReport"/> 
</BODY> 
</HTML> 
</xsl:template> 
<!--ģ���ܱ���  begin-->  
<xsl:template match="SimulationReport"> 
<TABLE BORDER="1" align="center"> 
<xsl:for-each select="WholeReport"> 
<CAPTION>ģ���ܱ���</CAPTION> 
<THEAD> 
<tr>
	<th>
	     <TD> <B>ȱʡ�ִ��ʱ��</B> </TD> 
	     <TD align="right"><xsl:value-of select="DeActPerformTime"/></TD> 
    </th>
</tr>
<tr>
	<th>
	     <TD> <B>ȱʡ���ʷֲ�</B> </TD> 
	     <TD align="right"><xsl:value-of select = "DeProbDis"/></TD> 
   </th>
</tr>
<tr>
	<th>
	     <TD> <B>ʱ�䵥λ</B> </TD> 
	     <TD align="right"><xsl:value-of select = "TimeUnit"/></TD> 
   </th>
</tr>
<tr>
	<th>
	     <TD> <B>ģ������ʱ��</B> </TD> 
	     <TD align="right"><xsl:value-of select = "SimExeDuration"/></TD> 
   </th>
</tr>
<tr>
	<th>
	     <TD> <B>�ܻ��</B> </TD> 
	     <TD align="right"><xsl:value-of select = "ActCount"/></TD> 
   </th>
</tr>
<tr>
	<th>
	     <TD> <B>����Ļ��</B> </TD> 
	     <TD align="right"><xsl:value-of select = "EnabledActCount"/></TD> 
   </th>
</tr>
<tr>
	<th>
	     <TD> <B>��Чʱ�����(Ԫ)</B> </TD> 
	     <TD align="right"><xsl:value-of select = "AvaTimeCost"/></TD> 
   </th>
</tr>
<tr>
	<th>
	     <TD> <B>����ʱ�����(Ԫ)</B> </TD> 
	     <TD align="right"><xsl:value-of select = "VacTimeCost"/></TD> 
   </th>
</tr>
<tr>
	<th>
	     <TD> <B>�ܷ���(Ԫ)</B> </TD> 
	     <TD align="right"><xsl:value-of select = "AllCost"/></TD> 
   </th>
</tr>
</THEAD> 
</xsl:for-each> 
</TABLE> 
<!--ģ���ܱ���  end-->

</xsl:template>
</xsl:stylesheet> 