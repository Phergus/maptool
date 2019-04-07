/*
 * This software Copyright by the RPTools.net development team, and
 * licensed under the Affero GPL Version 3 or, at your option, any later
 * version.
 *
 * MapTool Source Code is distributed in the hope that it will be
 * useful, but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * You should have received a copy of the GNU Affero General Public
 * License * along with this source Code.  If not, please visit
 * <http://www.gnu.org/licenses/> and specifically the Affero license
 * text at <http://www.gnu.org/licenses/agpl.html>.
 */
package net.rptools.maptool.client.functions;

import java.util.List;
import net.rptools.maptool.client.MapTool;
import net.rptools.parser.Parser;
import net.rptools.parser.ParserException;
import net.rptools.parser.function.AbstractFunction;
import net.sf.json.JSONArray;

public class LastRolledFunction extends AbstractFunction {
  private static final LastRolledFunction instance = new LastRolledFunction();

  private LastRolledFunction() {
    super(0, 1, "lastRolled", "getRolled");
  }

  public static LastRolledFunction getInstance() {
    return instance;
  }

  @Override
  public Object childEvaluate(Parser parser, String functionName, List<Object> parameters)
      throws ParserException {
    JSONArray jarr = new JSONArray();
    if (functionName.equalsIgnoreCase("lastRolled")) {
      jarr.addAll(MapTool.getParser().getLastRolled());
    } else {
      jarr.addAll(MapTool.getParser().getRolled());
    }

    return jarr;
  }
}
