package com.variamos.configurator.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.variamos.solver.Configuration;

public class ConfigurationIO {
	public static void saveToFile(ConfigurationDTO dto, String fileAbsPath)
			throws IOException {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		FileWriter writer = new FileWriter(fileAbsPath);
		writer.write(gson.toJson(dto));
		writer.close();
	}

	public static void saveMapToFile(Map<String, Integer> config,
			String fileAbsPath) throws IOException {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		FileWriter writer = new FileWriter(fileAbsPath);
		writer.write(gson.toJson(config));
		writer.close();
	}

	public static ConfigurationDTO loadFromFile(String fileAbsPath)
			throws FileNotFoundException {
		Gson gson = new GsonBuilder().create();

		FileReader fr = new FileReader(fileAbsPath);
		return gson.fromJson(fr, ConfigurationDTO.class);
	}

	public static Map<String, Integer> loadMapFromFile(String fileAbsPath)
			throws FileNotFoundException {
		Gson gson = new GsonBuilder().create();

		FileReader fr = new FileReader(fileAbsPath);
		@SuppressWarnings("unchecked")
		Map<String, Integer> out = gson.fromJson(fr, Map.class);
		try {
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return out;
	}

	public static void saveSolutions(List<Configuration> solutions,
			String fileAbsPath) throws FileNotFoundException {
		// Create a csv file
		PrintWriter out = new PrintWriter(new File(fileAbsPath));
		Configuration first = solutions.get(0);
		for (String strName : first.getConfiguration().keySet()) {
			out.print(strName);
			out.print(",");
			for (Configuration c : solutions) {
				out.print(c.stateOf(strName));
				out.print(",");
			}
			out.println();
		}
		out.close();
	}
}
