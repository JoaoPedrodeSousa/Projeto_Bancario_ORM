package model.Entities;

public interface IInterestOperations {
    default Double compoundInterest(Double value, Integer term, Double tax){
        return value * Math.pow((1.0+tax),term);
    }

    default Double simpleInterest(Double value, Integer term, Double tax){
        return value + (value * term * tax);
    }

}
