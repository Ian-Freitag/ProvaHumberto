import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	
    public static void main(String[] args) {
        List<Reserva> listaReservas = new ArrayList<>();
        List<Reserva> espera = new ArrayList<>();

        Scanner input = new Scanner(System.in);

        int num = 0;

        do {
            
            try {
            	 System.out.println();
                 System.out.println("Digite o numero do item desejado");
                 System.out.println("1. Reservar mesa");
                 System.out.println("2. Pesquisar mesa");
                 System.out.println("3. Imprimir reserva");
                 System.out.println("4. Imprimir lista de espera");
                 System.out.println("5. Cancelar reserva");
                 System.out.println("6. Finalizar");
                 System.out.println();

                 num = input.nextInt();
				
			} catch (java.util.InputMismatchException Exception) {	
			System.out.println("Digite um numero valido");
			input.nextLine();
			
			}
            
            switch (num) {
            case 1: //Reservar mesa
            	if(listaReservas.size() < 6) {
            		listaReservas.add(ReservarMesa(listaReservas));
            	} else {
            		System.out.println("Voce vai ser adicionado a lista de espera");
            		espera.add(ReservarMesa(espera));
            	}
                break;
            case 2: //Pesquisar mesa
            	Pesquisar(listaReservas);
                break;
            case 3: //Imprimir Reserva
            	ImprimirReservas(listaReservas);
                break;
            case 4: //imprimir lista de espera
            	ImprimirEspera(espera);
                break;
            case 5: //cancelar reserva
                break;
            }

        } 
        while (num != 6);
        System.out.println("Finish, Finalizado, c'est fini, Fertig");
    }
    
    //Reservar a mesa 
    public static Reserva ReservarMesa(List<Reserva> listaReservas) {
    	Scanner input = new Scanner(System.in);
    	
    	System.out.println("Digite o tipo de cliente que deseja cadastar:");
    	System.out.println("1. Pessoa fisica");
    	System.out.println("2. Pessoa juridica");
    	System.out.println();
    	
    	int tipoCliente = input.nextInt();
    	Cliente cliente = null;
    	
    	switch(tipoCliente) {
    	case 1: //cadasrar pessoa fisica
    		cliente = CadFis();
    		break;
    	case 2: //cadastrar pessoa juridica
    		cliente = CadJur();
    		break;
    	}
    	
    	// escolhendo a forma de pagamento
    	System.out.println("Qual é a forma de pagamento");
    	System.out.println("1. pagamento à vista");
    	System.out.println("2. Pagamento parcelado");
    	
    	int num = input.nextInt();
    	boolean avista = true;
    	
    	if (num == 1) {
    		avista = true;
    		
    	} else {
    		avista = false;
    		
    	}
    	
    	Reserva reserva = new Reserva(cliente, avista);
    	
    	return reserva;

    }
    
    
    //Cadastrar pessoa Fisica
    public static Cliente CadFis() {
    	Scanner input = new Scanner(System.in);
    	
    	System.out.println("Digite o nome do Cliente: ");
    	String nome = input.nextLine();
    	System.out.println("Digite o CPF do Cliente");
    	String cpf = input.nextLine();
    	PessoaFisica pesFis = new PessoaFisica(nome, cpf);
    	return pesFis;
    	
    }
    
    //Cadastar pessoa Jusridica
    //Cadastar pessoa Juridica
    public static Cliente CadJur() {
    	Scanner input = new Scanner(System.in);
    	
    	System.out.println("Digite o Nome do Cliente: ");
    	String nome = input.nextLine();
    	System.out.println("Digite o CNPJ do Cliente");
    	String cnpj = input.nextLine();
    	PessoaFisica pesJur = new PessoaFisica(nome, cnpj);
    	return pesJur;
    }
    
    //Pesquisar reserva
    public static void Pesquisar(List<Reserva> listaReservas) {
    	
    	System.out.println("Pesquisar por CPF ou CNPJ");
    	System.out.println("1. CPF");
    	System.out.println("2. CNPF");
    	
    	Scanner input = new Scanner(System.in);
    	int num = input.nextInt();
    	
    	
    	if(num == 1) { //pesquisando por CPF
    		System.out.println("digite o CPF deseja pesquisar");
    		String cpf = input.nextLine();
    		
    		for(int i = 0; i < listaReservas.size(); i++) {
        		PessoaFisica pessoinha = (PessoaFisica) listaReservas.get(i).getCliente();
        		if(pessoinha.getCpf().equals(cpf)) {
        			System.out.println("Esta pessoa POSSUI uma reserva ");
        		} else {
        			System.out.println("Esta pessoa NAO possui uma reserva! ");
        		}
        	}
    		
    	} else {
    		System.out.println("digite o CNPJ deseja pesquisar");
    		String cnpj = input.nextLine();
    		
    		for(int i = 0; i < listaReservas.size(); i++) {
        		PessoaJuridica pessoinhaJur = (PessoaJuridica) listaReservas.get(i).getCliente();
        		if(pessoinhaJur.getCnpj().equals(cnpj)) {
        			System.out.println("Esta pessoa POSSUI uma reserva ");
        		} else {
        			System.out.println("Esta pessoa NAO possui uma reserva! ");
        		}
        	}
    		
    	}
    	
    }
    
    //Imprimir resevas
    public static void ImprimirReservas(List<Reserva> listaReservas) {
    	
    	System.out.println(listaReservas);
    	
    }
    
    // Imprimir lista de espera
    public static void ImprimirEspera(List<Reserva> espera ) {
    	
    	System.out.println(espera);
    	
    }
    
    public static void CancelarReserva(List<Reserva> listaReservas, List<Reserva> espera){

    }
}