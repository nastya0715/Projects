package fedorova.models.hospitalProject.hospitals;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.apache.log4j.Logger;


@XmlRootElement (name="Laboratory")
@XmlAccessorType(XmlAccessType.FIELD)
public class Laboratory extends MedicalInstitutes {
	@XmlElement(name = "analysis")
	private String analysis;
	@XmlElement(name = "analysisType")
	private String analysisType;
	
	private final static Logger logger = Logger.getLogger(Laboratory.class);
	
	public Laboratory() {
	}
	
	public void analysisProcessing() {
		int a = (int) (Math.random());
		if (a==1) {
			logger.info("Analysis is good");}
			else {
				logger.info("Analysis is bad");
			}
	}
	
	public String getAnalysis() {
			return analysis;
		}
	public void setAnalysis(String analysis) {
			this.analysis = analysis;
		}
	
	public String getAnalysisType() {
		return analysisType;
	}

	public void setAnalysisType(String analysisType) {
		this.analysisType = analysisType;
	}
	@Override
	public String toString() {
		return "Laboratory [name= " +getName() + ", " +getAddress() +
				", analysis=" + analysis + ", analysisType=" + analysisType + "]";
	}
	
	
	
}
