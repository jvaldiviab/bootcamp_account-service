package com.project.accountservice.utilities.util;

public interface IAccountSpecificationsUtils {
    Double roundDouble(Double numberToRound, int decimalPlaces);
    Double applyInterests(Double amount, Double interestPercentage);
    Double calculateCommission(Double amount, Double interestPercentage);
}