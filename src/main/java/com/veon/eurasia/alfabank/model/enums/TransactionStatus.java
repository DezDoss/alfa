package com.veon.eurasia.alfabank.model.enums;

import lombok.Getter;
import java.util.Optional;

@Getter
public enum TransactionStatus {
  SUCCESS(0),
  FAIL(1),
  SESSION_ID_NOT_FOUND(3),
  MORE_THAN_ONE_SESSION(4),
  TRANSACTION_NOT_FOUND(5),
  IN_PROGRESS(8),
  UNKNOWN_ERROR(-1);

  private final int code;

  TransactionStatus(int code) {
    this.code = code;
  }

  public static Optional<TransactionStatus> findTransactionFromStatusCode(int code) {
    for(TransactionStatus transactionStatus : TransactionStatus.values()) {
      if (transactionStatus.code == code) {
        return Optional.of(transactionStatus);
      }
    }

    return Optional.of(UNKNOWN_ERROR);
  }
}
