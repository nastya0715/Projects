package fedorova.models.hospitalProject.address;

public enum City {

		MINSK(Country.BELARUS), BREST(Country.BELARUS), GRODNO(Country.BELARUS), GOMEL(Country.BELARUS), VITEBSK(Country.BELARUS), MOGILEV(Country.BELARUS),
		MOSKOW(Country.RUSSIA), SPB(Country.RUSSIA), KAZAN(Country.RUSSIA), UFA(Country.RUSSIA), SOCHI(Country.RUSSIA),
		MADRID(Country.SPAIN), SEVILLA(Country.SPAIN), BARCELONA(Country.SPAIN), ALICANTE(Country.SPAIN),
		LONDON(Country.ENGLAND), LIVERPOOL(Country.ENGLAND), MANCHESTER(Country.ENGLAND), YORK(Country.ENGLAND),
		SEOUL(Country.KOREA), BUSAN(Country.KOREA), DAEGU(Country.KOREA), INCHEON(Country.KOREA), DAEJEON(Country.KOREA),
		HONGKONG(Country.CHINA), MACAO(Country.CHINA), SHANGHAI(Country.CHINA), TIBET(Country.CHINA),
		CHICAGO(Country.USA), DALLAS(Country.USA), LASVEGAS(Country.USA), NEWYORK(Country.USA), ATLANTA(Country.USA), COLUMBIA(Country.USA),
		PARIS(Country.FRANCE), NICE(Country.FRANCE), MARSEILLE(Country.FRANCE), STRASBOURG(Country.FRANCE);
		
		private Country country;
		
		City(Country country){
			this.country = country;
		}
		
		public Country getCountry() {
			return country;
		}
}
