package controller;

import java.sql.Date;
import java.time.LocalDate;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author jakem - jrmeyer4
 * CIS175 - Fall 2021
 * Oct 7, 2021
 */
@Converter(autoApply =true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Date>{
	@Override
	public Date convertToDatabaseColumn(LocalDate attribute) {
	//TODOAuto-generated method stub
	return(attribute ==null ? null :Date.valueOf(attribute));
	}
	
	@Override
	public LocalDate convertToEntityAttribute(Date dbData) {
	//TODOAuto-generated method stub
	return(dbData ==null ? null : dbData.toLocalDate());
	}
}
