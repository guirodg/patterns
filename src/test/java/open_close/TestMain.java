package open_close;
// Open Closed Principle
// Dependency Inversion

import org.junit.jupiter.api.Test;

interface ValidaInterfaceComun {
  void valida();
}

public class TestMain {

  @Test
  void testOne() {
    final var validaSenha = new ValidaSenha();
    final var validaEmail = new ValidaEmail();
    final var validadorComposite = new ValidadorComposite(validaSenha, validaEmail);
    final var classConcretaNMuda = new ClassConcretaNMuda(validadorComposite);
    classConcretaNMuda.addValidacao();
  }

}

class ClassConcretaNMuda {
  private final ValidaInterfaceComun validaInterfaceComun;

  ClassConcretaNMuda(ValidaInterfaceComun validaInterfaceComun) {
    this.validaInterfaceComun = validaInterfaceComun;
  }

  void addValidacao() {
    validaInterfaceComun.valida();
  }
}

class ValidaEmail implements ValidaInterfaceComun {

  @Override
  public void valida() {
    System.out.println("Validando Email");

  }
}

class ValidaSenha implements ValidaInterfaceComun {

  @Override
  public void valida() {
    System.out.println("Validando Senha");

  }
}

//Composition Root
class ValidadorComposite implements ValidaInterfaceComun {

  private final ValidaSenha validaSenha;
  private final ValidaEmail validaEmail;

  ValidadorComposite(ValidaSenha validaSenha, ValidaEmail validaEmail) {
    this.validaSenha = validaSenha;
    this.validaEmail = validaEmail;
  }

  @Override
  public void valida() {
    this.validaSenha.valida();
    this.validaEmail.valida();
  }
}




