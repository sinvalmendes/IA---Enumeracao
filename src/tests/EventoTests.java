/**
 * 
 */
package tests;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;
import model.Condicao;
import model.Tabela;
import model.Estado;
import model.Node;

import org.junit.Before;
import org.junit.Test;

/**
 * @author sinval
 * 
 */
public class EventoTests {
	private Node r;
	private Node t;
	private Node a;
	private Node j;
	private Node m;

	private Tabela controladorDeConsultas;

	@Before
	public void setUp() {
		r = new Node("R - Roubo");
		t = new Node("T - Terremoto");
		a = new Node("A - Alarme");
		j = new Node("J - João liga");
		m = new Node("M - Maria liga");
		controladorDeConsultas = new Tabela();
	}

	public void montarRede() {
		a.addPai(r);
		a.addPai(t);
		j.addPai(a);
		m.addPai(a);
	}

	@Test
	public void montarRedeTest() {
		this.montarRede();

		Assert.assertTrue(a.getPais().contains(r));
		Assert.assertTrue(a.getPais().contains(t));
		Assert.assertEquals(2, a.getPais().size());

		Assert.assertTrue(j.getPais().contains(a));
		Assert.assertEquals(1, j.getPais().size());

		Assert.assertTrue(m.getPais().contains(a));
		Assert.assertEquals(1, m.getPais().size());

	}

	@Test
	public void criarUmaCondicaoValida() {
		this.montarRede();

		Estado estadoRtrue = new Estado(true, this.r);
		Estado estadoTtrue = new Estado(true, this.t);
		Estado estadoAtrue = new Estado(true, this.a);

		Condicao rtaTrue = new Condicao(0.95);
		rtaTrue.addEstado(estadoRtrue);
		rtaTrue.addEstado(estadoTtrue);
		rtaTrue.addEstado(estadoAtrue);

		Assert.assertTrue(rtaTrue.getEvidencias().contains(estadoRtrue));
		Assert.assertTrue(rtaTrue.getEvidencias().contains(estadoTtrue));
		Assert.assertTrue(rtaTrue.getEvidencias().contains(estadoAtrue));
		Assert.assertEquals(0.95, rtaTrue.getProbabilidade());
	}

	@Test
	public void fazerConsultaValida() throws Exception {
		this.montarRede();

		Estado estadoRtrue = new Estado(true, this.r);
		Estado estadoTtrue = new Estado(true, this.t);
		Estado estadoAtrue = new Estado(true, this.a);

		Condicao rtaTrue = new Condicao(0.95);
		rtaTrue.addEstado(estadoRtrue);
		rtaTrue.addEstado(estadoTtrue);
		rtaTrue.addEstado(estadoAtrue);

		Assert.assertTrue(rtaTrue.getEvidencias().contains(estadoRtrue));
		Assert.assertTrue(rtaTrue.getEvidencias().contains(estadoTtrue));
		Assert.assertTrue(rtaTrue.getEvidencias().contains(estadoAtrue));
		Assert.assertEquals(0.95, rtaTrue.getProbabilidade());

		this.controladorDeConsultas.addCondicao(rtaTrue);

		List<Estado> consulta = new ArrayList<Estado>();
		consulta.add(estadoRtrue);
		consulta.add(estadoTtrue);
		consulta.add(estadoAtrue);

		Assert.assertEquals(0.95,
				this.controladorDeConsultas.consulta(consulta));

	}

}
