package classification;

import org.biojava.bio.dist.Distribution;
import org.biojava.bio.symbol.IllegalSymbolException;
import org.biojava.bio.symbol.Symbol;
import org.biojava.bio.symbol.SymbolList;

import java.util.Iterator;

public class NaiveBayesClass {

    private Distribution[] featureVector;

    public NaiveBayesClass() {
        this.featureVector = new Distribution[0];
    }

    public Distribution[] getFeatureVector() {
        return featureVector;
    }

    public void setFeatureVector(Distribution[] featureVector) {
        this.featureVector = featureVector;
    }

    public double pObservation(SymbolList obs) throws IllegalSymbolException{
        if (obs == null) {
            throw new IllegalArgumentException("obs can not be bull!");
        }
        if (obs.length() != featureVector.length) {
            throw new IllegalArgumentException("obs and featureVector should have the same size!");
        }

        double prob = 0;
        int i = 0;
        for (Iterator iterator = obs.iterator(); iterator.hasNext(); i++) {
            Symbol symbol = (Symbol) iterator.next();
            Distribution distribution = featureVector[i];
            prob += Math.log(distribution.getWeight(symbol));
        }
        return prob;
    }

}
