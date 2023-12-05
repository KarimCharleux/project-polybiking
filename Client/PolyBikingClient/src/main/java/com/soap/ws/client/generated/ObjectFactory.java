
package com.soap.ws.client.generated;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.datatype.Duration;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.soap.ws.client.generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private static final QName _BikingResponse_QNAME = new QName("http://schemas.datacontract.org/2004/07/PolyBiking", "BikingResponse");
    private static final QName _ArrayOfPath_QNAME = new QName("http://schemas.datacontract.org/2004/07/PolyBiking", "ArrayOfPath");
    private static final QName _Path_QNAME = new QName("http://schemas.datacontract.org/2004/07/PolyBiking", "Path");
    private static final QName _StationInfo_QNAME = new QName("http://schemas.datacontract.org/2004/07/PolyBiking", "StationInfo");
    private static final QName _Position_QNAME = new QName("http://schemas.datacontract.org/2004/07/PolyBiking", "Position");
    private static final QName _ArrayOfPosition_QNAME = new QName("http://schemas.datacontract.org/2004/07/PolyBiking", "ArrayOfPosition");
    private static final QName _ArrayOfStep_QNAME = new QName("http://schemas.datacontract.org/2004/07/PolyBiking", "ArrayOfStep");
    private static final QName _Step_QNAME = new QName("http://schemas.datacontract.org/2004/07/PolyBiking", "Step");
    private static final QName _PathType_QNAME = new QName("http://schemas.datacontract.org/2004/07/PolyBiking", "PathType");
    private static final QName _ArrayOfint_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "ArrayOfint");
    private static final QName _AnyType_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "anyType");
    private static final QName _AnyURI_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "anyURI");
    private static final QName _Base64Binary_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "base64Binary");
    private static final QName _Boolean_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "boolean");
    private static final QName _Byte_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "byte");
    private static final QName _DateTime_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "dateTime");
    private static final QName _Decimal_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "decimal");
    private static final QName _Double_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "double");
    private static final QName _Float_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "float");
    private static final QName _Int_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "int");
    private static final QName _Long_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "long");
    private static final QName _QName_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "QName");
    private static final QName _Short_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "short");
    private static final QName _String_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "string");
    private static final QName _UnsignedByte_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedByte");
    private static final QName _UnsignedInt_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedInt");
    private static final QName _UnsignedLong_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedLong");
    private static final QName _UnsignedShort_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "unsignedShort");
    private static final QName _Char_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "char");
    private static final QName _Duration_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "duration");
    private static final QName _Guid_QNAME = new QName("http://schemas.microsoft.com/2003/10/Serialization/", "guid");
    private static final QName _ComputeTripAddressOrigin_QNAME = new QName("http://tempuri.org/", "addressOrigin");
    private static final QName _ComputeTripAddressDestination_QNAME = new QName("http://tempuri.org/", "addressDestination");
    private static final QName _ComputeTripResponseComputeTripResult_QNAME = new QName("http://tempuri.org/", "ComputeTripResult");
    private static final QName _StepInstruction_QNAME = new QName("http://schemas.datacontract.org/2004/07/PolyBiking", "Instruction");
    private static final QName _StepName_QNAME = new QName("http://schemas.datacontract.org/2004/07/PolyBiking", "Name");
    private static final QName _StepWayPoints_QNAME = new QName("http://schemas.datacontract.org/2004/07/PolyBiking", "WayPoints");
    private static final QName _StationInfoAddress_QNAME = new QName("http://schemas.datacontract.org/2004/07/PolyBiking", "Address");
    private static final QName _StationInfoContractName_QNAME = new QName("http://schemas.datacontract.org/2004/07/PolyBiking", "ContractName");
    private static final QName _StationInfoLastUpdate_QNAME = new QName("http://schemas.datacontract.org/2004/07/PolyBiking", "LastUpdate");
    private static final QName _StationInfoStatus_QNAME = new QName("http://schemas.datacontract.org/2004/07/PolyBiking", "Status");
    private static final QName _PathArrivalStation_QNAME = new QName("http://schemas.datacontract.org/2004/07/PolyBiking", "arrivalStation");
    private static final QName _PathCoordinates_QNAME = new QName("http://schemas.datacontract.org/2004/07/PolyBiking", "coordinates");
    private static final QName _PathDepartingStation_QNAME = new QName("http://schemas.datacontract.org/2004/07/PolyBiking", "departingStation");
    private static final QName _PathSteps_QNAME = new QName("http://schemas.datacontract.org/2004/07/PolyBiking", "steps");
    private static final QName _BikingResponsePaths_QNAME = new QName("http://schemas.datacontract.org/2004/07/PolyBiking", "Paths");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.soap.ws.client.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ComputeTrip }
     * 
     * @return
     *     the new instance of {@link ComputeTrip }
     */
    public ComputeTrip createComputeTrip() {
        return new ComputeTrip();
    }

    /**
     * Create an instance of {@link ComputeTripResponse }
     * 
     * @return
     *     the new instance of {@link ComputeTripResponse }
     */
    public ComputeTripResponse createComputeTripResponse() {
        return new ComputeTripResponse();
    }

    /**
     * Create an instance of {@link BikingResponse }
     * 
     * @return
     *     the new instance of {@link BikingResponse }
     */
    public BikingResponse createBikingResponse() {
        return new BikingResponse();
    }

    /**
     * Create an instance of {@link ArrayOfPath }
     * 
     * @return
     *     the new instance of {@link ArrayOfPath }
     */
    public ArrayOfPath createArrayOfPath() {
        return new ArrayOfPath();
    }

    /**
     * Create an instance of {@link Path }
     * 
     * @return
     *     the new instance of {@link Path }
     */
    public Path createPath() {
        return new Path();
    }

    /**
     * Create an instance of {@link StationInfo }
     * 
     * @return
     *     the new instance of {@link StationInfo }
     */
    public StationInfo createStationInfo() {
        return new StationInfo();
    }

    /**
     * Create an instance of {@link Position }
     * 
     * @return
     *     the new instance of {@link Position }
     */
    public Position createPosition() {
        return new Position();
    }

    /**
     * Create an instance of {@link ArrayOfPosition }
     * 
     * @return
     *     the new instance of {@link ArrayOfPosition }
     */
    public ArrayOfPosition createArrayOfPosition() {
        return new ArrayOfPosition();
    }

    /**
     * Create an instance of {@link ArrayOfStep }
     * 
     * @return
     *     the new instance of {@link ArrayOfStep }
     */
    public ArrayOfStep createArrayOfStep() {
        return new ArrayOfStep();
    }

    /**
     * Create an instance of {@link Step }
     * 
     * @return
     *     the new instance of {@link Step }
     */
    public Step createStep() {
        return new Step();
    }

    /**
     * Create an instance of {@link ArrayOfint }
     * 
     * @return
     *     the new instance of {@link ArrayOfint }
     */
    public ArrayOfint createArrayOfint() {
        return new ArrayOfint();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BikingResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BikingResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/PolyBiking", name = "BikingResponse")
    public JAXBElement<BikingResponse> createBikingResponse(BikingResponse value) {
        return new JAXBElement<>(_BikingResponse_QNAME, BikingResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfPath }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfPath }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/PolyBiking", name = "ArrayOfPath")
    public JAXBElement<ArrayOfPath> createArrayOfPath(ArrayOfPath value) {
        return new JAXBElement<>(_ArrayOfPath_QNAME, ArrayOfPath.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Path }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Path }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/PolyBiking", name = "Path")
    public JAXBElement<Path> createPath(Path value) {
        return new JAXBElement<>(_Path_QNAME, Path.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StationInfo }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StationInfo }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/PolyBiking", name = "StationInfo")
    public JAXBElement<StationInfo> createStationInfo(StationInfo value) {
        return new JAXBElement<>(_StationInfo_QNAME, StationInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Position }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Position }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/PolyBiking", name = "Position")
    public JAXBElement<Position> createPosition(Position value) {
        return new JAXBElement<>(_Position_QNAME, Position.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfPosition }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfPosition }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/PolyBiking", name = "ArrayOfPosition")
    public JAXBElement<ArrayOfPosition> createArrayOfPosition(ArrayOfPosition value) {
        return new JAXBElement<>(_ArrayOfPosition_QNAME, ArrayOfPosition.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfStep }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfStep }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/PolyBiking", name = "ArrayOfStep")
    public JAXBElement<ArrayOfStep> createArrayOfStep(ArrayOfStep value) {
        return new JAXBElement<>(_ArrayOfStep_QNAME, ArrayOfStep.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Step }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Step }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/PolyBiking", name = "Step")
    public JAXBElement<Step> createStep(Step value) {
        return new JAXBElement<>(_Step_QNAME, Step.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PathType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link PathType }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/PolyBiking", name = "PathType")
    public JAXBElement<PathType> createPathType(PathType value) {
        return new JAXBElement<>(_PathType_QNAME, PathType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/Arrays", name = "ArrayOfint")
    public JAXBElement<ArrayOfint> createArrayOfint(ArrayOfint value) {
        return new JAXBElement<>(_ArrayOfint_QNAME, ArrayOfint.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "anyType")
    public JAXBElement<Object> createAnyType(Object value) {
        return new JAXBElement<>(_AnyType_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "anyURI")
    public JAXBElement<String> createAnyURI(String value) {
        return new JAXBElement<>(_AnyURI_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "base64Binary")
    public JAXBElement<byte[]> createBase64Binary(byte[] value) {
        return new JAXBElement<>(_Base64Binary_QNAME, byte[].class, null, ((byte[]) value));
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "boolean")
    public JAXBElement<Boolean> createBoolean(Boolean value) {
        return new JAXBElement<>(_Boolean_QNAME, Boolean.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Byte }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Byte }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "byte")
    public JAXBElement<Byte> createByte(Byte value) {
        return new JAXBElement<>(_Byte_QNAME, Byte.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "dateTime")
    public JAXBElement<XMLGregorianCalendar> createDateTime(XMLGregorianCalendar value) {
        return new JAXBElement<>(_DateTime_QNAME, XMLGregorianCalendar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BigDecimal }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "decimal")
    public JAXBElement<BigDecimal> createDecimal(BigDecimal value) {
        return new JAXBElement<>(_Decimal_QNAME, BigDecimal.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Double }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Double }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "double")
    public JAXBElement<Double> createDouble(Double value) {
        return new JAXBElement<>(_Double_QNAME, Double.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Float }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Float }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "float")
    public JAXBElement<Float> createFloat(Float value) {
        return new JAXBElement<>(_Float_QNAME, Float.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "int")
    public JAXBElement<Integer> createInt(Integer value) {
        return new JAXBElement<>(_Int_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Long }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "long")
    public JAXBElement<Long> createLong(Long value) {
        return new JAXBElement<>(_Long_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link QName }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link QName }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "QName")
    public JAXBElement<QName> createQName(QName value) {
        return new JAXBElement<>(_QName_QNAME, QName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Short }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "short")
    public JAXBElement<Short> createShort(Short value) {
        return new JAXBElement<>(_Short_QNAME, Short.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "string")
    public JAXBElement<String> createString(String value) {
        return new JAXBElement<>(_String_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Short }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Short }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedByte")
    public JAXBElement<Short> createUnsignedByte(Short value) {
        return new JAXBElement<>(_UnsignedByte_QNAME, Short.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Long }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedInt")
    public JAXBElement<Long> createUnsignedInt(Long value) {
        return new JAXBElement<>(_UnsignedInt_QNAME, Long.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedLong")
    public JAXBElement<BigInteger> createUnsignedLong(BigInteger value) {
        return new JAXBElement<>(_UnsignedLong_QNAME, BigInteger.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "unsignedShort")
    public JAXBElement<Integer> createUnsignedShort(Integer value) {
        return new JAXBElement<>(_UnsignedShort_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Integer }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "char")
    public JAXBElement<Integer> createChar(Integer value) {
        return new JAXBElement<>(_Char_QNAME, Integer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Duration }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Duration }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "duration")
    public JAXBElement<Duration> createDuration(Duration value) {
        return new JAXBElement<>(_Duration_QNAME, Duration.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.microsoft.com/2003/10/Serialization/", name = "guid")
    public JAXBElement<String> createGuid(String value) {
        return new JAXBElement<>(_Guid_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "addressOrigin", scope = ComputeTrip.class)
    public JAXBElement<String> createComputeTripAddressOrigin(String value) {
        return new JAXBElement<>(_ComputeTripAddressOrigin_QNAME, String.class, ComputeTrip.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "addressDestination", scope = ComputeTrip.class)
    public JAXBElement<String> createComputeTripAddressDestination(String value) {
        return new JAXBElement<>(_ComputeTripAddressDestination_QNAME, String.class, ComputeTrip.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BikingResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link BikingResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://tempuri.org/", name = "ComputeTripResult", scope = ComputeTripResponse.class)
    public JAXBElement<BikingResponse> createComputeTripResponseComputeTripResult(BikingResponse value) {
        return new JAXBElement<>(_ComputeTripResponseComputeTripResult_QNAME, BikingResponse.class, ComputeTripResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/PolyBiking", name = "Instruction", scope = Step.class)
    public JAXBElement<String> createStepInstruction(String value) {
        return new JAXBElement<>(_StepInstruction_QNAME, String.class, Step.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/PolyBiking", name = "Name", scope = Step.class)
    public JAXBElement<String> createStepName(String value) {
        return new JAXBElement<>(_StepName_QNAME, String.class, Step.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfint }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/PolyBiking", name = "WayPoints", scope = Step.class)
    public JAXBElement<ArrayOfint> createStepWayPoints(ArrayOfint value) {
        return new JAXBElement<>(_StepWayPoints_QNAME, ArrayOfint.class, Step.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/PolyBiking", name = "Address", scope = StationInfo.class)
    public JAXBElement<String> createStationInfoAddress(String value) {
        return new JAXBElement<>(_StationInfoAddress_QNAME, String.class, StationInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/PolyBiking", name = "ContractName", scope = StationInfo.class)
    public JAXBElement<String> createStationInfoContractName(String value) {
        return new JAXBElement<>(_StationInfoContractName_QNAME, String.class, StationInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Long }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Long }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/PolyBiking", name = "LastUpdate", scope = StationInfo.class)
    public JAXBElement<Long> createStationInfoLastUpdate(Long value) {
        return new JAXBElement<>(_StationInfoLastUpdate_QNAME, Long.class, StationInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/PolyBiking", name = "Name", scope = StationInfo.class)
    public JAXBElement<String> createStationInfoName(String value) {
        return new JAXBElement<>(_StepName_QNAME, String.class, StationInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Position }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Position }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/PolyBiking", name = "Position", scope = StationInfo.class)
    public JAXBElement<Position> createStationInfoPosition(Position value) {
        return new JAXBElement<>(_Position_QNAME, Position.class, StationInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link String }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/PolyBiking", name = "Status", scope = StationInfo.class)
    public JAXBElement<String> createStationInfoStatus(String value) {
        return new JAXBElement<>(_StationInfoStatus_QNAME, String.class, StationInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StationInfo }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StationInfo }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/PolyBiking", name = "arrivalStation", scope = Path.class)
    public JAXBElement<StationInfo> createPathArrivalStation(StationInfo value) {
        return new JAXBElement<>(_PathArrivalStation_QNAME, StationInfo.class, Path.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfPosition }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfPosition }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/PolyBiking", name = "coordinates", scope = Path.class)
    public JAXBElement<ArrayOfPosition> createPathCoordinates(ArrayOfPosition value) {
        return new JAXBElement<>(_PathCoordinates_QNAME, ArrayOfPosition.class, Path.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StationInfo }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link StationInfo }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/PolyBiking", name = "departingStation", scope = Path.class)
    public JAXBElement<StationInfo> createPathDepartingStation(StationInfo value) {
        return new JAXBElement<>(_PathDepartingStation_QNAME, StationInfo.class, Path.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfStep }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfStep }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/PolyBiking", name = "steps", scope = Path.class)
    public JAXBElement<ArrayOfStep> createPathSteps(ArrayOfStep value) {
        return new JAXBElement<>(_PathSteps_QNAME, ArrayOfStep.class, Path.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArrayOfPath }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link ArrayOfPath }{@code >}
     */
    @XmlElementDecl(namespace = "http://schemas.datacontract.org/2004/07/PolyBiking", name = "Paths", scope = BikingResponse.class)
    public JAXBElement<ArrayOfPath> createBikingResponsePaths(ArrayOfPath value) {
        return new JAXBElement<>(_BikingResponsePaths_QNAME, ArrayOfPath.class, BikingResponse.class, value);
    }

}
