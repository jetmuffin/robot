package com.dag.robot.nlp;
import java.util.List;

import org.junit.Test;

import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.Sentence;
import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import edu.stanford.nlp.trees.Tree;
import edu.stanford.nlp.trees.TreebankLanguagePack;
import edu.stanford.nlp.trees.TypedDependency;
import edu.stanford.nlp.trees.international.pennchinese.ChineseGrammaticalStructure;
import edu.stanford.nlp.trees.international.pennchinese.ChineseGrammaticalStructureFactory;
import edu.stanford.nlp.trees.international.pennchinese.ChineseTreebankLanguagePack;

public class StanfordParser {

	private static LexicalizedParser lp = LexicalizedParser
			.loadModel("edu/stanford/nlp/models/lexparser/chinesePCFG.ser.gz");

	public static String getRoot(String string[]) {
		List<CoreLabel> rawWords = Sentence.toCoreLabelList(string);
		Tree parse = lp.parse(rawWords);
		TreebankLanguagePack tlp = new ChineseTreebankLanguagePack();
		ChineseGrammaticalStructureFactory cgsf = (ChineseGrammaticalStructureFactory) tlp
				.grammaticalStructureFactory();
		ChineseGrammaticalStructure cgs = cgsf.newGrammaticalStructure(parse);
		List<TypedDependency> tdl = cgs.typedDependenciesCCprocessed();
		System.out.println(tdl);

		for (int i = 0; i < tdl.size(); i++) {
			TypedDependency td = tdl.get(i);
			if (td.reln().toString().equals("cop")) {
				String temp = td.gov().pennString();
				if (temp.startsWith("什么")) {
					for (int j = 0; j < tdl.size(); j++) {
						TypedDependency td1 = tdl.get(j);
						if (td1.reln().toString().equals("nsubj")) {
							return td1.dep().pennString();
						}
					}
				}else {
					return temp;
				}
			}
			else if (td.reln().toString().equals("case")) {
				return td.gov().pennString();
			}
			else if (td.reln().toString().equals("dobj")) {
				return td.dep().pennString();
			}
			
		}
		return null;
	}

	public static String parse(String string[]){
		String string2 = getRoot(string);
		String string3 = string2.substring(0, string2.length()-1);
		return string3;
	}

}
