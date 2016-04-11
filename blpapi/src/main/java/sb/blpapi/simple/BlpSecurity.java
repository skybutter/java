package sb.blpapi.simple;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

public class BlpSecurity {

	private final static Logger logger = Logger.getLogger(BlpSecurity.class.getName());
	
    private String yellowKey = null;
    private String cusip = null;
    private String isin = null;
    private String ticker = null;
    private String coupon = null;
    private String maturity = null;
    private String exchangeCode = null;
    private String securitySearch = null;

    // DateFormat and DecimalFormat are not thread safe, not using static
    public final DateFormat dateFormat = new SimpleDateFormat("MM/dd/yy");
    private final DecimalFormat couponFormatter = new DecimalFormat("0.0###########");

    public String getYellowKey () {
        return yellowKey;
    }

    public void setYellowKey (String yellowKey) {
        this.yellowKey = yellowKey;
    }

    public String getCusip () {
        return cusip;
    }

    public void setCusip (String cusip) {
        this.cusip = cusip;
    }

    public String getIsin () {
        return isin;
    }

    public void setIsin (String isin) {
        this.isin = isin;
    }

    public String getTicker () {
        return ticker;
    }

    public void setTicker (String ticker) {
        this.ticker = ticker;
    }

    public String getCoupon () {
        return coupon;
    }

    public void setCoupon (double coupon) {
    	// Format the double to the value Bloomberg expect 
        if (!Double.isNaN(coupon)) {
            this.coupon = couponFormatter.format(coupon);
        } else
        	this.coupon = null;
    }
    public void setCoupon (String coupon) {
    	// Format the double to the value Bloomberg expect 
        if (!StringUtil.isEmptyString(coupon)) {
            try {
                Double d = new Double(coupon);
                this.coupon = couponFormatter.format(d);
            } catch (Exception e) {
                logger.severe("Unable to parse string value of [" + coupon + "] to double.");
            }
        } else {
        	this.coupon = null;
        }
    }

    public String getMaturity () {
        return maturity;
    }

    public Date getMaturityDt () {
        if (maturity != null) {
            try {
                return dateFormat.parse(maturity);
            } catch (ParseException e) {
            	logger.severe("Unable to parse string value of [" + maturity + "] to Date.");
            }
        }
        return null;
    }

    public void setMaturity (String maturity) {
        this.maturity = maturity;
    }

    public void setMaturityDt (Date maturity) {
        if (maturity != null) {
            this.maturity = dateFormat.format(maturity);
        }
    }

    public String getExchangeCode () {
        return exchangeCode;
    }

    public void setExchangeCode (String exchangeCode) {
        this.exchangeCode = exchangeCode;
    }

    public boolean isValid () {
        return hasYellowKey() && hasIdentifier();
    }

    public boolean hasIdentifier () {
        return (ticker != null || cusip != null || isin != null );
    }

    public boolean hasYellowKey () {
        return yellowKey != null;
    }

    /**
     * The SecuritySearch must be in the format which Bloomberg expects.
     */
    public String getSecuritySearch() {
        if (!StringUtil.isEmptyString(securitySearch)) {
            return securitySearch;
        }
        if (!StringUtil.isEmptyString(yellowKey)) {
            if (!StringUtil.isEmptyString(cusip)) {
                return cusip + " " + yellowKey;
            }
            if (!StringUtil.isEmptyString(isin)) {
                return isin + " " + yellowKey;
            }
            if (!StringUtil.isEmptyString(ticker)) {
                return ticker + (coupon != null ? " " + coupon : "") + (maturity != null ? " " + maturity : "")
                    + (exchangeCode != null ? " " + exchangeCode : "") + " " + yellowKey;
            }
        }
        return null;
    }

    public void setSecuritySearch(String s) {
        this.securitySearch = s;
    }

    @Override
    // Eclipse generated method
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((securitySearch == null) ? 0 : securitySearch.hashCode());
		return result;
	}

    @Override
    // Eclipse generated method
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BlpSecurity other = (BlpSecurity) obj;
		if (securitySearch == null) {
			if (other.securitySearch != null)
				return false;
		} else if (!securitySearch.equals(other.securitySearch))
			return false;
		return true;
	}

    public String toString () {
        return getSecuritySearch();
    }
}
