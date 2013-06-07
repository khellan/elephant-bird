package com.twitter.elephantbird.pig.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import org.apache.pig.data.DataType;
import org.apache.pig.data.Tuple;
import org.apache.pig.EvalFunc;
import org.apache.pig.FuncSpec;
import org.apache.pig.impl.logicalLayer.FrontendException;
import org.apache.pig.impl.logicalLayer.schema.Schema;
import org.apache.pig.impl.logicalLayer.schema.Schema.FieldSchema;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class is responsible for parsing a {@link String} with json and returning
 * something a bit more usable like a {@link Map} that we can use from pig
 */
public class JsonParser extends EvalFunc<Map> {
  private static final Logger LOG = LoggerFactory.getLogger(JsonParser.class);
  protected JSONParser parser = new JSONParser();

  /**
   * Parses a String, probably a line into a {@link JSONObject} which is also a
   * {@link Map}. Will return null on error rather than an exception since this
   * is expected to be run in a MapReduce where we would prefer to get the 
   * results we can even if there are errors.
   *
   * @param line The {@link String} line (normally) of text to parse
   * @return A {@link Map} version of the json string
   */
  protected Map parseLine(String line) {
    try {
      return (JSONObject)parser.parse(line);
    } catch (ParseException e) {
      LOG.warn("Could not json-decode string: " + line, e);
      return new JSONObject();
    } catch (NumberFormatException e) {
      LOG.warn("Very big number exceeds the scale of long: " + line, e);
      return new JSONObject();
    } catch (ClassCastException e) {
      LOG.warn("ClassCastException, expected JSONObject: " + line, e);
      return new JSONObject();
    }
  }

  @Override
    public Map exec(Tuple input) throws IOException {
      if (input == null || input.size() == 0) return null;

      Object object = input.get(0);
      if (object == null) return null;
     
      Map payload = parseLine(((String)object).trim());
      // Pig doesn't like Complex members in it's Maps
      for (Object key : payload.keySet()) {
        if (payload.get(key) instanceof JSONArray || payload.get(key) instanceof JSONObject) {
          payload.put(key, payload.get(key).toString());
        }
      }
      return payload;
    }

  @Override
    public List<FuncSpec> getArgToFuncMapping() throws FrontendException {
      List<FuncSpec> funcList = new ArrayList<FuncSpec>();
      funcList.add(
          new FuncSpec(
            this.getClass().getName(), 
            new Schema(
              new Schema.FieldSchema(null, DataType.BYTEARRAY)
              )
            )
          );

      return funcList;
    }
}
