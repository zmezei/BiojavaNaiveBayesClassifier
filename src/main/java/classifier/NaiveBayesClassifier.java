package classifier;

import classification.NaiveBayesClass;
import org.biojava.bio.dist.Distribution;
import org.biojava.bio.symbol.IllegalSymbolException;
import org.biojava.bio.symbol.SymbolList;

import java.util.Map;

public class NaiveBayesClassifier {

    private Map name2Classifier;
    private Map name2Prior;
    private double totalPrior;

    public void addClassification(String name, Distribution[] featureVector, double prior) {

    }

    public double getPriorProb(String classificationName){
        Double priorProb = (Double) name2Prior.get(classificationName);
        return priorProb / totalPrior;
    }

    public double logProbClass(String classificationName,
                               SymbolList obs) throws IllegalSymbolException {
        if (!name2Classifier.containsKey(classificationName) || !name2Prior.containsKey(classificationName)) {
            throw new IllegalArgumentException(classificationName + " not found!");
        }

        NaiveBayesClass naiveBayesClass = (NaiveBayesClass) name2Classifier.get(classificationName);
        return Math.log(getPriorProb(classificationName)) + naiveBayesClass.pObservation(obs);
    }

}
