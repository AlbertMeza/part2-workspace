package gov.irs.enumtype;

import gov.irs.TaxPayer;

public interface IRS {

  static IRS getInstance(){
    return IRSEnum.getInstance();
  }

  void collectTaxes();
  void register(TaxPayer payer);
}
