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
<TABLE BORDER="1"> 
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

<!--��Ʒͳ������  begin-->
<TABLE BORDER="1"> 
<xsl:for-each select="ProdResult"> 
<CAPTION>��Ʒͳ������</CAPTION> 
<THEAD> 
<TD> <B>��Ʒ����</B> </TD> 
<TD> <B>��������</B> </TD> 
<TD> <B>����</B> </TD> 
<TD> <B>���������ʷֲ�</B> </TD>
<TD> <B>��������ֵ</B> </TD>
<TD> <B>��������׼����</B> </TD>
<TD> <B>�ȴ�ʱ���ֵ</B> </TD>
<TD> <B>�ȴ�ʱ���׼����</B> </TD>
</THEAD> 
<xsl:for-each select="ProdData"> 
<TR> 
<TD align="left"><xsl:value-of select="ProdName"/></TD> 
<TD align="right"><xsl:value-of select="InOrOut"/></TD> 
<TD align="right"><xsl:value-of select="Count"/></TD>
<xsl:for-each select="ReachInterval">
	<TD align="right"><xsl:value-of select = "ProbDistibution"/></TD>
	<xsl:for-each select="AVGAndSD">
		<TD align="right"><xsl:value-of select="Average"/></TD> 
		<TD align="right"><xsl:value-of select="STDevation"/></TD>
	</xsl:for-each>
</xsl:for-each>
<xsl:for-each select="WaittingTime">
	<TD align="right"><xsl:value-of select="Average"/></TD> 
	<TD align="right"><xsl:value-of select="STDevation"/></TD>
</xsl:for-each>
</TR> 
</xsl:for-each> 
</xsl:for-each> 
</TABLE> 
<!--��Ʒͳ������  end-->

<!--����ͳ������  begin-->
<TABLE BORDER="1"> 
<xsl:for-each select="SeqResult"> 
<CAPTION>����ͳ������</CAPTION> 
<THEAD> 
<TD> <B>��������</B> </TD> 
<TD> <B>�ӳ���ֵ</B> </TD> 
<TD> <B>�ӳ���׼����</B> </TD> 
<TD> <B>���ӳ�</B> </TD>
<TD> <B>�ȴ�ʱ���ֵ</B> </TD>
<TD> <B>�ȴ�ʱ���׼����</B> </TD>
<TD> <B>��������</B> </TD>
<TD> <B>�������</B> </TD>
<TD> <B>������ʣ����</B> </TD>
</THEAD> 
<xsl:for-each select="SeqData"> 
<TR> 
<TD align="left"><xsl:value-of select="Name"/></TD> 
<xsl:for-each select="SeqLength">
	<TD align="right"><xsl:value-of select = "Average"/></TD>
	<TD align="right"><xsl:value-of select="STDevation"/></TD>
</xsl:for-each>
<TD align="right"><xsl:value-of select="MaxLength"/></TD>
<xsl:for-each select="WaittingTime">
	<TD align="right"><xsl:value-of select="Average"/></TD> 
	<TD align="right"><xsl:value-of select="STDevation"/></TD>
</xsl:for-each>
<TD align="right"><xsl:value-of select="InputCount"/></TD> 
<TD align="right"><xsl:value-of select="OutputCount"/></TD> 
<TD align="right"><xsl:value-of select="LeftCount"/></TD> 
</TR>
</xsl:for-each>
</xsl:for-each> 
</TABLE> 
<!--����ͳ������  end-->

<!--�ͳ������  begin-->
<TABLE BORDER="1"> 
<xsl:for-each select="ActResult"> 
<CAPTION>�ͳ������</CAPTION> 
<THEAD> 
<TD> <B>�����</B> </TD> 
<TD> <B>����ʱ�䣨Сʱ��</B> </TD> 
<TD> <B>ִ��ʱ����ʷֲ�</B> </TD>
<TD> <B>ִ��ʱ���ֵ</B> </TD>
<TD> <B>ִ��ʱ���׼����</B> </TD>
<TD> <B>�ȴ�ʱ���ֵ</B> </TD>
<TD> <B>�ȴ�ʱ���׼����</B> </TD>
<TD> <B>ִ����ɴ���</B> </TD>
<TD> <B>�ܷ��ã�Ԫ��</B> </TD>
<TD> <B>����������ֵ</B> </TD>
<TD> <B>����������׼����</B> </TD>
</THEAD> 
<xsl:for-each select="ActData"> 
<TR> 
<TD align="left"><xsl:value-of select="Name"/></TD> 
<TD align="right"><xsl:value-of select="WorkDuration"/></TD> 
<xsl:for-each select="ExcuteDuration">
	<TD align="right"><xsl:value-of select = "ProbDistibution"/></TD>
	<xsl:for-each select="AVGAndSD">
		<TD align="right"><xsl:value-of select="Average"/></TD> 
		<TD align="right"><xsl:value-of select="STDevation"/></TD>
	</xsl:for-each>
</xsl:for-each>
<xsl:for-each select="WaittingTime">
	<TD align="right"><xsl:value-of select="Average"/></TD> 
	<TD align="right"><xsl:value-of select="STDevation"/></TD>
</xsl:for-each>
<TD align="right"><xsl:value-of select="ExcuteTimes"/></TD> 
<TD align="right"><xsl:value-of select="AllCost"/></TD> 
<xsl:for-each select="Batch">
	<TD align="right"><xsl:value-of select="Average"/></TD> 
	<TD align="right"><xsl:value-of select="STDevation"/></TD>
</xsl:for-each>
</TR> 
</xsl:for-each> 
</xsl:for-each> 
</TABLE> 
<!--�ͳ������  end-->

<!--��Դͳ������  begin-->
<TABLE BORDER="1"> 
<xsl:for-each select="ResResult"> 
<CAPTION>��Դͳ������</CAPTION> 
<THEAD> 
<TD> <B>��Դ����</B> </TD> 
<TD> <B>��Դ����</B> </TD> 
<TD> <B>����</B> </TD> 
<TD> <B>�����ʾ�ֵ</B> </TD>
<TD> <B>�����ʱ�׼����</B> </TD>
<TD> <B>�����ʰٷֱ�(%)</B> </TD>
<TD> <B>����ʱ���ֵ</B> </TD>
<TD> <B>����ʱ���׼����</B> </TD>
<TD> <B>��Ч������</B> </TD>
<TD> <B>���з��ã�Ԫ��</B> </TD>
<TD> <B>�ܷ��ã�Ԫ��</B> </TD>
</THEAD> 
<xsl:for-each select="ResData"> 
<TR> 
<TD align="left"><xsl:value-of select="ResClass"/></TD> 
<TD align="right"><xsl:value-of select="ResType"/></TD> 
<TD align="right"><xsl:value-of select="Count"/></TD>
<xsl:for-each select="UsingRate">
	<xsl:for-each select="AVGAndSD">
		<TD align="right"><xsl:value-of select="Average"/></TD> 
		<TD align="right"><xsl:value-of select="STDevation"/></TD>
	</xsl:for-each>
	<TD align="right"><xsl:value-of select = "Percent"/></TD>
</xsl:for-each>
<xsl:for-each select="WorkDuration">
	<TD align="right"><xsl:value-of select="Average"/></TD> 
	<TD align="right"><xsl:value-of select="STDevation"/></TD>
</xsl:for-each>
<TD align="right"><xsl:value-of select="AvaDuration"/></TD> 
<TD align="right"><xsl:value-of select="VacTimeCost"/></TD> 
<TD align="right"><xsl:value-of select="AllCost"/></TD>
</TR> 
</xsl:for-each>
</xsl:for-each> 
</TABLE> 
<!--��Դͳ������  end-->

</xsl:template>
</xsl:stylesheet> 