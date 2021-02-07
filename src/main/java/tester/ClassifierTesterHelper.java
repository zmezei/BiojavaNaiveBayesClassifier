package tester;

import classifier.NaiveBayesClassifier;
import org.biojava.bio.dist.Distribution;
import org.biojava.bio.dist.SimpleDistribution;
import org.biojava.bio.seq.DNATools;
import org.biojava.bio.symbol.IllegalSymbolException;
import org.biojava.bio.symbol.SymbolList;

public class ClassifierTesterHelper {

    private Distribution[] gcRichFeature;
    private Distribution[] atRichFeature;
    private SymbolList gcRichSymbolList;
    private SymbolList atRichSymbolList;
    private NaiveBayesClassifier nbClassifier;

    public ClassifierTesterHelper() throws Exception {
        nbClassifier = new NaiveBayesClassifier();
        initGcRichFeature();
        initAtRichFeature();
        nbClassifier.addClassification("gcRich", gcRichFeature, 0.5);
        nbClassifier.addClassification("atRich", atRichFeature, 0.5);

        gcRichSymbolList = DNATools.createDNA("gtctgaagtg");
        atRichSymbolList = DNATools.createDNA("accaacgtac");
    }

    private void initGcRichFeature() throws Exception {
        gcRichFeature = new Distribution[10];
        for (int i = 0; i < gcRichFeature.length; i++) {
            gcRichFeature[i] = new SimpleDistribution(DNATools.getDNA());
            gcRichFeature[i].setWeight(DNATools.a(), 0.1);
            gcRichFeature[i].setWeight(DNATools.t(), 0.1);
            gcRichFeature[i].setWeight(DNATools.g(), 0.4);
            gcRichFeature[i].setWeight(DNATools.c(), 0.4);
        }
    }

    private void initAtRichFeature() throws Exception {
        atRichFeature = new Distribution[10];
        for (int i = 0; i < atRichFeature.length; i++) {
            atRichFeature[i] = new SimpleDistribution(DNATools.getDNA());
            atRichFeature[i].setWeight(DNATools.a(), 0.4);
            atRichFeature[i].setWeight(DNATools.t(), 0.4);
            atRichFeature[i].setWeight(DNATools.g(), 0.1);
            atRichFeature[i].setWeight(DNATools.c(), 0.1);
        }
    }

    public void classify() {
        //TODO
    }


}
