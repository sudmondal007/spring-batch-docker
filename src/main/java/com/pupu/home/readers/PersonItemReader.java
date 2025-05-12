package com.pupu.home.readers;

import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.core.io.ClassPathResource;

import com.pupu.home.dto.Member;

public class PersonItemReader extends FlatFileItemReader<Member> {
	
	public PersonItemReader() {
		System.out.println("\n\n\nPersonItemReader constructor called..........\n\n\n");
		setResource(new ClassPathResource("data2.csv"));
		setLineMapper(new DefaultLineMapper<>() {
			{
				setLineTokenizer(new DelimitedLineTokenizer() {
					{
						setNames("firstName", "lastName");
					}
				});
				setFieldSetMapper(new BeanWrapperFieldSetMapper<>() {
					{
						setTargetType(Member.class);
					}
				});
			}
		});
	}
}
