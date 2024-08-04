package academy.devdojo.maratonajava.javacore.ZZHpadroesdeprojeto.dominio;

// O último padrão de projeto que nós vamos falar é o Data Transfer Object os famosos DTOs, na verdade ele é um padrão
// arquitetural de aplicações corporativas
// Qual o problema que esse padrão tenta resolver? Imagina que a gente tem que mandar uma determinada quantidade de
// dados pra uma API, digamos assim nossa API precisa do seguinte dado: precisa do nome da aeronave, a gente precisa de
// um país, nós precisamos também da moeda daquele país e nós precisamos do nome de uma pessoa, ou seja, você precisa
// de dados de quatro tipos de entidades diferentes, então não tem como você passar todos a quantidade de dados seria
// imensa
// Então, o Data Transfer Object é um padrão de projeto onde você cria uma classe basicamente com os atributos que você
// quer
// Agora que nós temos um DTO se eu precisar fazer uma transferência desses objetos diretamente para uma outra API,
// digamos cada um desses atributos, ao invés de pegar e passar quatro objetos diferentes eu pego e monto um só na
// verdade você está fazendo um agrupamento dos atributos que você precisa por isso que ele chama Data Transfer Object
// você só passa exatamente aquilo que é importante, que é preciso
public class ReportDto {
    private String aircraftName;
    private Country country;
    private Currency currency;
    private String personName;

    public static final class ReportDtoBuilder {
        private String aircraftName;
        private Country country;
        private Currency currency;
        private String personName;

        private ReportDtoBuilder() {
        }

        public static ReportDtoBuilder builder() {
            return new ReportDtoBuilder();
        }

        public ReportDtoBuilder aircraftName(String aircraftName) {
            this.aircraftName = aircraftName;
            return this;
        }

        public ReportDtoBuilder country(Country country) {
            this.country = country;
            return this;
        }

        public ReportDtoBuilder currency(Currency currency) {
            this.currency = currency;
            return this;
        }

        public ReportDtoBuilder personName(String personName) {
            this.personName = personName;
            return this;
        }

        public ReportDto build() {
            ReportDto reportDto = new ReportDto();
            reportDto.country = this.country;
            reportDto.currency = this.currency;
            reportDto.aircraftName = this.aircraftName;
            reportDto.personName = this.personName;
            return reportDto;
        }
    }

    @Override
    public String toString() {
        return "ReportDto{" +
                "aircraftName='" + aircraftName + '\'' +
                ", country=" + country +
                ", currency=" + currency +
                ", personName='" + personName + '\'' +
                '}';
    }
}
