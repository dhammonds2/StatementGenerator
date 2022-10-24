package org.example;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class ReadJSON {
    public List<Account> accounts = new ArrayList<>();

    public ReadJSON(String filepath) throws IOException {
        ReadTheJSON(filepath);
    }

    private void ReadTheJSON(String filepath) throws IOException {
        JSONParser parser = new JSONParser();

        try(Reader reader = new FileReader(filepath)){
            JSONArray personalTrades = (JSONArray) parser.parse(reader);
            for(Object object : personalTrades){
                JSONObject newObject = (JSONObject) object;

                Account account = new Account();

                account.setAccountNumber((Long) newObject.get("account_number"));
                account.setSsn((String) newObject.get("ssn"));
                account.setFirstName((String) newObject.get("first_name"));
                account.setLastName((String) newObject.get("last_name"));
                account.setEmail((String) newObject.get("email"));
                account.setPhone((String) newObject.get("phone"));
                account.setBeginningBalance((String) newObject.get("beginning_balance"));

                JSONArray tradesInStock = (JSONArray) newObject.get("stock_trades");
                for (Object trades : tradesInStock){
                    JSONObject objectTrades = (JSONObject) trades;
                    StockMarketTrades newTrade = new StockMarketTrades();

                    newTrade.setType((String) objectTrades.get("type"));
                    newTrade.setStockSymbol((String) objectTrades.get("stock_symbol"));
                    newTrade.setCountShares((Long) objectTrades.get("count_shares"));
                    newTrade.setPricePerShare((String) objectTrades.get("price_per_share"));

                    account.getStockTrades().add(newTrade);
                }
                accounts.add(account);
            }

            } catch (org.json.simple.parser.ParseException exception){
                exception.printStackTrace();
            }

        }
    }

