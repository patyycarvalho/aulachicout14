package br.com;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class App 
{ 
    public static void main(String[] args) {
    // Carregando o objeto serializado da ContaBancaria do arquivo
    ContaBancaria conta = null;
    try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("conta.dat"))) {
        conta = (ContaBancaria) inputStream.readObject();
        System.out.println("Conta carregada com sucesso!");
    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
    }

    if (conta != null) {
        // Atualizando o saldo da conta
        conta.depositar(100.0); // Exemplo: adicionando R$ 100.00 ao saldo

        // Serializando o objeto atualizado de volta ao arquivo
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("conta.dat"))) {
            outputStream.writeObject(conta);
            System.out.println("Conta atualizada e serializada com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
}