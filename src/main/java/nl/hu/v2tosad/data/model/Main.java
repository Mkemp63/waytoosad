package nl.hu.v2tosad.data.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
		java.util.Date yourDate = sdf.parse("29-01-2018");
		BusinessRule br = new BusinessRule(69, "implementing", yourDate, "codename", "inter entity", "rule name", "description geen discription", "table1");
		InterEntityCompareRule ie = new InterEntityCompareRule(br, 69, "column1", "table2", "column2","EQUALS", 69, 69);
		Generate g = GenerateFactory.doGenerate("Oracle");
		System.out.println(g.generateInterEntityCompareRule(ie));
		g = null;
		br = null;
		ie = null;
	}
}
