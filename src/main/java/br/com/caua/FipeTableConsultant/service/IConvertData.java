package br.com.caua.FipeTableConsultant.service;

import java.util.List;

public interface IConvertData {
    <T> T getObject(String json, Class<T> tClass);

    <T> List<T> getList(String json, Class<T> tClass);
}
