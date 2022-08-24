package stream_api;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainRunnerTest {
  @Test
  void testePrimeiro() {
    final var joao = new Cliente();
    joao.setIdade(18);
    joao.setNome("João da Silva");
    final var maria = new Cliente();
    maria.setIdade(50);
    maria.setNome("Maria Rodrigues");
    final var clientes = new ArrayList<Cliente>();
    clientes.add(joao);
    clientes.add(maria);

    clientes.stream()
        .filter(c -> c.getIdade() <= 18)
        .forEach(System.out::println);

    final var clienteDTOS = clientes.stream()
        .map(ClienteDTO::new).collect(Collectors.toList());

    clienteDTOS.forEach(System.out::println);

    // Metodos intermediario não fecha a stream.... Metodos Terminados Fecha a stream e mostra resultado
  }
}

@Getter
@Setter
@ToString
class Cliente {
  private int idade;
  private String nome;
}

@Getter
@Setter
@ToString
class ClienteDTO {
  private String nome;

  public ClienteDTO(Cliente cliente) {
    this.nome = cliente.getNome();
  }
}
