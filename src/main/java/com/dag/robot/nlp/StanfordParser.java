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

	LexicalizedParser lp = LexicalizedParser
			.loadModel("edu/stanford/nlp/models/lexparser/chinesePCFG.ser.gz");

	public String getRoot(String string[]) {
		List<CoreLabel> rawWords = Sentence.toCoreLabelList(string);
		Tree parse = lp.parse(rawWords);
		TreebankLanguagePack tlp = new ChineseTreebankLanguagePack();
		ChineseGrammaticalStructureFactory cgsf = (ChineseGrammaticalStructureFactory) tlp
				.grammaticalStructureFactory();
		ChineseGrammaticalStructure cgs = cgsf.newGrammaticalStructure(parse);
		List<TypedDependency> tdl = cgs.typedDependenciesCCprocessed();
		for (int i = 0; i < tdl.size(); i++) {
			TypedDependency td = tdl.get(i);
			if (td.reln().toString().equals("root")) {
				return td.dep().pennString();
			}
		}
		return null;
	}
	
}
