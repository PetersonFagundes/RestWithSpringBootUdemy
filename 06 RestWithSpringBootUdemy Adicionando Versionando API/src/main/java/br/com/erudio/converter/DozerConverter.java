package br.com.erudio.converter;

import java.util.ArrayList;
import java.util.List;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

//Classe responsável por converter o VO em model
public class DozerConverter {

	private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();
	
	public static <Origem, Destino> Destino parseObject(Origem origin, Class<Destino> destination) {
		return mapper.map(origin, destination);
	}
	
	public static <Origem, Destino> List<Destino> parseListObjects(List<Origem> origin, Class<Destino> destination) {
		List<Destino> destinationObjects = new ArrayList<Destino>();
		for (Object o : origin) {
			destinationObjects.add(mapper.map(o, destination));
		}
		return destinationObjects;
	}
}
