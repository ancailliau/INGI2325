package uclouvain.ingi2325.parser;

import uclouvain.ingi2325.exception.ParseException;
import uclouvain.ingi2325.utils.Color;
import uclouvain.ingi2325.utils.Point3D;
import uclouvain.ingi2325.utils.TextureCoordinates;
import uclouvain.ingi2325.utils.Vector3D;

public class EchoParserHandler implements ParserHandler {

	private int indent;
	static final private String indentString = "   ";

	public void startSdl() throws ParseException {
		indent = 0;
		System.out.println("<Sdl>");
	}

	public void endSdl() throws ParseException {
		System.out.println("</Sdl>");
	}

	public void startCameras() throws ParseException {
		indent++;
		for (int i = 0; i < indent; i++)
			System.out.print(indentString);
		System.out.println("<Cameras>");
	}

	public void endCameras() throws ParseException {
		for (int i = 0; i < indent; i++)
			System.out.print(indentString);
		System.out.println("</Cameras>");
		indent--;
	}

	public void startCamera(Point3D position, Vector3D direction, Vector3D up,
			float fovy, String name) throws ParseException {
		indent++;
		for (int i = 0; i < indent; i++)
			System.out.print(indentString);
		System.out.println("<Camera" + " position=\""
				+ ParserUtils.formatTuple3f(position) + "\"" + " direction=\""
				+ ParserUtils.formatTuple3f(direction) + "\"" + " up=\""
				+ ParserUtils.formatTuple3f(up) + "\"" + " fovy=\"" + fovy
				+ "\"" + " name=\"" + name + "\"" + ">");
	}

	public void endCamera() throws ParseException {
		for (int i = 0; i < indent; i++)
			System.out.print(indentString);
		System.out.println("</Camera>");
		indent--;
	}

	public void startLights() throws ParseException {
		indent++;
		for (int i = 0; i < indent; i++)
			System.out.print(indentString);
		System.out.println("<Lights>");
	}

	public void endLights() throws ParseException {
		for (int i = 0; i < indent; i++)
			System.out.print(indentString);
		System.out.println("</Lights>");
		indent--;
	}

	public void startDirectionalLight(Vector3D direction, float intensity,
			Color color, String name) throws ParseException {
		indent++;
		for (int i = 0; i < indent; i++)
			System.out.print(indentString);
		System.out.println("<DirectionalLight" + " direction=\""
				+ ParserUtils.formatTuple3f(direction) + "\"" + " intensity=\""
				+ intensity + "\"" + " color=\""
				+ ParserUtils.formatTuple3f(color) + "\"" + " name=\"" + name
				+ "\"" + ">");
	}

	public void endDirectionalLight() throws ParseException {
		for (int i = 0; i < indent; i++)
			System.out.print(indentString);
		System.out.println("</DirectionalLight>");
		indent--;
	}

	public void startPointLight(Point3D position, float intensity, Color color,
			String name) throws ParseException {
		indent++;
		for (int i = 0; i < indent; i++)
			System.out.print(indentString);
		System.out.println("<PointLight" + " position=\""
				+ ParserUtils.formatTuple3f(position) + "\"" + " intensity=\""
				+ intensity + "\"" + " color=\""
				+ ParserUtils.formatTuple3f(color) + "\"" + " name=\"" + name
				+ "\"" + ">");

	}

	public void endPointLight() throws ParseException {
		for (int i = 0; i < indent; i++)
			System.out.print(indentString);
		System.out.println("</PointLight>");
		indent--;
	}

	public void startSpotLight(Point3D position, Vector3D direction,
			float angle, float intensity, Color color, String name)
			throws ParseException {
		indent++;
		for (int i = 0; i < indent; i++)
			System.out.print(indentString);
		System.out.println("<SpotLight" + " direction=\""
				+ ParserUtils.formatTuple3f(direction) + "\"" + " position=\""
				+ ParserUtils.formatTuple3f(position) + "\"" + " angle=\""
				+ angle + "\"" + " intensity=\"" + intensity + "\"" + " up=\""
				+ ParserUtils.formatTuple3f(color) + "\"" + " name=\"" + name
				+ "\"" + ">");
	}

	public void endSpotLight() throws ParseException {
		for (int i = 0; i < indent; i++)
			System.out.print(indentString);
		System.out.println("</SpotLight>");
		indent--;
	}

	public void startGeometry() throws ParseException {
		indent++;
		for (int i = 0; i < indent; i++)
			System.out.print(indentString);
		System.out.println("<Geometry>");
	}

	public void endGeometry() throws ParseException {
		for (int i = 0; i < indent; i++)
			System.out.print(indentString);
		System.out.println("</Geometry>");
		indent--;
	}

	public void startSphere(float radius, String name) throws ParseException {
		indent++;
		for (int i = 0; i < indent; i++)
			System.out.print(indentString);
		System.out.println("<Sphere" + " radius=\"" + radius + "\""
				+ " name=\"" + name + "\"" + ">");

	}

	public void endSphere() throws ParseException {
		for (int i = 0; i < indent; i++)
			System.out.print(indentString);
		System.out.println("</Sphere>");
		indent--;
	}

	public void startCylinder(float radius, float height, boolean capped,
			String name) throws ParseException {
		indent++;
		for (int i = 0; i < indent; i++)
			System.out.print(indentString);
		System.out.println("<Cylinder" + " radius=\"" + radius + "\""
				+ " height=\"" + height + "\"" + " capped=\"" + capped + "\""
				+ " name=\"" + name + "\"" + ">");
	}

	public void endCylinder() throws ParseException {
		for (int i = 0; i < indent; i++)
			System.out.print(indentString);
		System.out.println("</Cylinder>");
		indent--;
	}

	public void startCone(float radius, float height, boolean capped,
			String name) throws ParseException {
		indent++;
		for (int i = 0; i < indent; i++)
			System.out.print(indentString);
		System.out.println("<Cone" + " radius=\"" + radius + "\""
				+ " height=\"" + height + "\"" + " capped=\"" + capped + "\""
				+ " name=\"" + name + "\"" + ">");
	}

	public void endCone() throws ParseException {
		for (int i = 0; i < indent; i++)
			System.out.print(indentString);
		System.out.println("</Cone>");
		indent--;
	}

	public void startTorus(float innerRadius, float outerRadius, String name)
			throws ParseException {
		indent++;
		for (int i = 0; i < indent; i++)
			System.out.print(indentString);
		System.out.println("<Torus" + " innerRadius=\"" + innerRadius + "\""
				+ " outerRadius=\"" + outerRadius + "\"" + " name=\"" + name
				+ "\"" + ">");
	}

	public void endTorus() throws ParseException {
		for (int i = 0; i < indent; i++)
			System.out.print(indentString);
		System.out.println("</Torus>");
		indent--;
	}

	public void startTeapot(float size, String name) throws ParseException {
		indent++;
		for (int i = 0; i < indent; i++)
			System.out.print(indentString);
		System.out.println("<Teapot" + " size=\"" + size + "\"" + " name=\""
				+ name + "\"" + ">");
	}

	public void endTeapot() throws ParseException {
		for (int i = 0; i < indent; i++)
			System.out.print(indentString);
		System.out.println("</Teapot>");
		indent--;
	}

	public void startIndexedTriangleSet(Point3D[] coordinates,
			Vector3D[] normals, TextureCoordinates[] textureCoordinates,
			int[] coordinateIndices, int[] normalIndices,
			int[] textureCoordinateIndices, String name) throws ParseException {
		indent++;
		for (int i = 0; i < indent; i++)
			System.out.print(indentString);
		System.out
				.println("<IndexedTriangleSet"
						+ " coordinates=\""
						+ ParserUtils.formatTuple3fArray(coordinates)
						+ "\""
						+ (normals == null ? "" : " normals=\""
								+ ParserUtils.formatTuple3fArray(normals)
								+ "\"")
						+ (textureCoordinates == null ? ""
								: " textureCoordinates=\""
										+ ParserUtils
												.formatTuple2fArray(textureCoordinates)
										+ "\"")
						+ " coordinateIndices=\""
						+ ParserUtils.formatIntArray(coordinateIndices)
						+ "\""
						+ (normalIndices == null ? "" : " normalIndices=\""
								+ ParserUtils.formatIntArray(normalIndices)
								+ "\"")
						+ (textureCoordinateIndices == null ? ""
								: " textureCoordinateIndices=\""
										+ ParserUtils
												.formatIntArray(textureCoordinateIndices)
										+ "\"") + " name=\"" + name + "\""
						+ ">");
	}

	public void endIndexedTriangleSet() throws ParseException {
		for (int i = 0; i < indent; i++)
			System.out.print(indentString);
		System.out.println("</IndexedTriangleSet>");
		indent--;
	}

	@Override
	public void startFileGeometry(String filename, String name)
			throws Exception {
		indent++;
		for (int i = 0; i < indent; i++)
			System.out.print(indentString);
		System.out.println("<FileGeometry" + " filename=\"" + filename + "\""
				+ " name=\"" + name + "\"" + ">");
	}

	@Override
	public void endFileGeometry() throws Exception {
		for (int i = 0; i < indent; i++)
			System.out.print(indentString);
		System.out.println("</FileGeometry>");
		indent--;
	}

	public void startTextures() throws ParseException {
		indent++;
		for (int i = 0; i < indent; i++)
			System.out.print(indentString);
		System.out.println("<Textures>");
	}

	public void endTextures() throws ParseException {
		for (int i = 0; i < indent; i++)
			System.out.print(indentString);
		System.out.println("</Textures>");
		indent--;
	}

	public void startTexture(String src, String name) throws ParseException {
		indent++;
		for (int i = 0; i < indent; i++)
			System.out.print(indentString);
		System.out.println("<Texture" + " src=\"" + name + "\"" + " name=\""
				+ name + "\"" + ">");
	}

	public void endTexture() throws ParseException {
		for (int i = 0; i < indent; i++)
			System.out.print(indentString);
		System.out.println("</Texture>");
		indent--;
	}

	public void startMaterials() throws ParseException {
		indent++;
		for (int i = 0; i < indent; i++)
			System.out.print(indentString);
		System.out.println("<Materials>");
	}

	public void endMaterials() throws ParseException {
		for (int i = 0; i < indent; i++)
			System.out.print(indentString);
		System.out.println("</Materials>");
		indent--;
	}

	public void startDiffuseMaterial(Color color, String name)
			throws ParseException {
		indent++;
		for (int i = 0; i < indent; i++)
			System.out.print(indentString);
		System.out.println("<DiffuseMaterial" + " color=\""
				+ ParserUtils.formatTuple3f(color) + "\"" + " name=\"" + name
				+ "\"" + ">");
	}

	public void endDiffuseMaterial() throws Exception {
		for (int i = 0; i < indent; i++)
			System.out.print(indentString);
		System.out.println("</DiffuseMaterial>");
		indent--;
	}

	public void startPhongMaterial(Color color, float shininess, String name)
			throws Exception {
		indent++;
		for (int i = 0; i < indent; i++)
			System.out.print(indentString);
		System.out.println("<PhongMaterial" + " color=\""
				+ ParserUtils.formatTuple3f(color) + "\"" + " shininess=\""
				+ shininess + "\"" + " name=\"" + name + "\"" + ">");
	}

	public void endPhongMaterial() throws Exception {
		for (int i = 0; i < indent; i++)
			System.out.print(indentString);
		System.out.println("</PhongMaterial>");
		indent--;
	}

	public void startLinearCombinedMaterial(String material1Name,
			float weight1, String material2Name, float weight2, String name)
			throws Exception {
		indent++;
		for (int i = 0; i < indent; i++)
			System.out.print(indentString);
		System.out.println("<LinearCombinedMaterial" + " material1=\""
				+ material1Name + "\"" + " weight1=\"" + weight1 + "\""
				+ " material2=\"" + material2Name + "\"" + " weight2=\""
				+ weight2 + "\"" + ">");
	}

	public void endLinearCombinedMaterial() throws Exception {
		for (int i = 0; i < indent; i++)
			System.out.print(indentString);
		System.out.println("</LinearCombinedMaterial>");
		indent--;
	}

	public void startScene(String cameraName, String[] lightNames,
			Color background) throws Exception {
		indent++;
		for (int i = 0; i < indent; i++)
			System.out.print(indentString);
		System.out.println("<Scene" + " camera=\"" + cameraName + "\""
				+ " lights=\"" + ParserUtils.formatStringArray(lightNames)
				+ "\"" + " background=\""
				+ ParserUtils.formatTuple3f(background) + "\"" + ">");
	}

	public void endScene() throws Exception {
		for (int i = 0; i < indent; i++)
			System.out.print(indentString);
		System.out.println("</Scene>");
		indent--;
	}

	public void startShape(String geometryName, String materialName,
			String textureName) throws Exception {
		indent++;
		for (int i = 0; i < indent; i++)
			System.out.print(indentString);
		System.out.println("<Shape"
				+ " geometry=\""
				+ geometryName
				+ "\""
				+ (materialName == null ? "" : " material=\"" + materialName
						+ "\"")
				+ (textureName == null ? "" : " texture=\"" + textureName
						+ "\"") + ">");
	}

	public void endShape() throws Exception {
		for (int i = 0; i < indent; i++)
			System.out.print(indentString);
		System.out.println("</Shape>");
		indent--;
	}

	public void startRotate(Vector3D axis, float angle) throws Exception {
		indent++;
		for (int i = 0; i < indent; i++)
			System.out.print(indentString);
		System.out.println("<Rotate" + " axis=\""
				+ ParserUtils.formatTuple3f(axis) + "\"" + " angle=\"" + angle
				+ "\"" + ">");
	}

	public void endRotate() throws Exception {
		for (int i = 0; i < indent; i++)
			System.out.print(indentString);
		System.out.println("</Rotate>");
		indent--;
	}

	public void startTranslate(Vector3D vector) throws Exception {
		indent++;
		for (int i = 0; i < indent; i++)
			System.out.print(indentString);
		System.out.println("<Translate" + " vector=\""
				+ ParserUtils.formatTuple3f(vector) + "\"" + ">");
	}

	public void endTranslate() throws Exception {
		for (int i = 0; i < indent; i++)
			System.out.print(indentString);
		System.out.println("</Translate>");
		indent--;
	}

	public void startScale(Vector3D scale) throws Exception {
		indent++;
		for (int i = 0; i < indent; i++)
			System.out.print(indentString);
		System.out.println("<Scale" + " scale=\""
				+ ParserUtils.formatTuple3f(scale) + "\"" + ">");
	}

	public void endScale() throws Exception {
		for (int i = 0; i < indent; i++)
			System.out.print(indentString);
		System.out.println("</Scale>");
		indent--;
	}

}
