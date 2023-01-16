package src;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.print("What ingredients are we searching today? : ");
        Scanner sc = new Scanner(System.in);
        String q = sc.nextLine();
        String url = "https://tasty.p.rapidapi.com/recipes/list?from=0&size=20&q=" + q;
        HttpRequest request = HttpRequest.newBuilder()
		.uri(URI.create(url))
		.header("X-RapidAPI-Key", "05a1dfa1d9msha52dc756e85eb78p16f6acjsn090d0e7ec1e5")
		.header("X-RapidAPI-Host", "tasty.p.rapidapi.com")
		.method("GET", HttpRequest.BodyPublishers.noBody())
		.build();
        HttpResponse<String> response;
        try {
            response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());    
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
