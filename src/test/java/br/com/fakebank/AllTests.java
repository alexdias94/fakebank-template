package br.com.fakebank;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ FakeBankTesteUnidade.class, TesteGUIAtdd.class, TesteIntegracao.class })
public class AllTests {

}
