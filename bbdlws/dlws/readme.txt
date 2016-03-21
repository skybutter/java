This dlws directory contained the Bloomberg Data License WSDL.
The generated/java directory contained the code generated from WSDL.
There are a number of ways to generate the Java code from WSDL for jaxb or jaxws.

You can use Apache CXF WSDL to Java
or Ant script wsconsume.

Since the code use Apache CXF to connect to the Web Service,
it is only logical to use Apache CXF WSDL to convert.
Instruction is not documented here.

For Keystore
1. Obtain keystore from Bloomberg
2. Convert keystore into JKS format
3. Here is the steps:

export PATH=/var/jdk1.7.0_51/bin:$PATH 
#Export Bloomberg PKCS12 Store to files 
openssl pkcs12 -nocerts -in DLWSCert.p12 -passin pass:<PASSWORD> -out Blp-DLWS.pem -passout pass:<PASSWORD> 
openssl pkcs12 -clcerts -nokeys -in DLWSCert.p12 -passin pass:<PASSWORD> -out Blp-DLWS-cert.pem 
openssl pkcs12 -cacerts -nokeys -in DLWSCert.p12 -passin pass:<PASSWORD> -out Bloomberg-DataServices-cert.pem 
#Convert PEM to DER 
openssl pkcs8 -topk8 -nocrypt -in Blp-DLWS.pem -inform PEM -out Blp-DLWS.der -outform DER -passin pass:<PASSWORD> 
openssl x509 -in Blp-DLWS-cert.pem -inform PEM -out Blp-DLWS-cert.der -outform DER 
openssl x509 -in Bloomberg-DataServices-cert.pem -inform PEM -out Bloomberg-DataServices-cert.der -outform DER 
#Import Bloomberg key and cert into keystore 
keytool -importkeystore -srckeystore DLWSCert.p12 -destkeystore blp-keystore.jks -srcstorepass <PASSWORD> -deststorepass <PASSWORD> -srcstoretype pkcs12 -deststoretype jks -noprompt 
#Import Bloomberg CA certs into truststore 
keytool -importcert -alias BloombergDataServices0 -file Blp-DLWS-cert.der -noprompt -trustcacerts -keystore blp-truststore.jks -storepass <PASSWORD> -v 
keytool -importcert -alias BloombergDataServices1 -file Bloomberg-DataServices-cert.der -noprompt -trustcacerts -keystore blp-truststore.jks -storepass <PASSWORD> -v 
#Verisign Secure Site Pro/Managed PKI for SSL Premium and Premium Intranet Certificates
#Download from http://www.verisign.com/support/verisign-intermediate-ca/secure-site-pro-intermediate/index.html 
openssl x509 -in SecureSiteProManagedPKIforSSLPremiumandPremiumIntranetCertificates.pem -inform PEM -out SecureSiteProManagedPKIforSSLPremiumandPremiumIntranetCertificates.der -outform DER 
#Import Verisign CA intermediate cert into truststore 
keytool -importcert -alias BloombergDataServices2 -file SecureSiteProManagedPKIforSSLPremiumandPremiumIntranetCertificates.der -noprompt -trustcacerts -keystore blp-truststore.jks -storepass <PASSWORD> -v 
keytool -list -v -keystore blp-keystore.jks -storepass <PASSWORD> 
keytool -list -v -keystore blp-truststore.jks -storepass <PASSWORD> 
#Combine the keystore and truststore together (= keystore + truststore) 
keytool -importkeystore -srckeystore blp-truststore.jks -destkeystore blp-keystore.jks -srcstorepass <PASSWORD> -deststorepass <PASSWORD> -noprompt 
keytool -list -v -keystore blp-keystore.jks -storepass <PASSWORD>
