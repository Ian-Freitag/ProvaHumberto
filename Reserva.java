
public class Reserva {
	private Cliente cliente;
	private boolean pagamentoAVista;
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public boolean getPagamentoAVista() {
		return pagamentoAVista;
	}
	
	public void setPagamentoAVista(boolean pagamentoAVista) {
		this.pagamentoAVista = pagamentoAVista;
	}
	
	public Reserva(Cliente cliente, boolean pagamentoAVista) {
		this.cliente = cliente;
		this.pagamentoAVista = pagamentoAVista;
	}
	
	@Override
	public String toString() {
		return cliente +" -- "+ "Foi a vista? " + pagamentoAVista;
	}
	
}
