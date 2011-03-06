package uclouvain.ingi2325.parser;

import uclouvain.ingi2325.utils.*;

import static uclouvain.ingi2325.parser.Contains.ManySpec.*;

/**
 * Handler of the parser
 * <p>This interface implicitly defines the whole structure of SDL files. Each
 * element Elem of the SDL file must be represented by a method startElem() and
 * a method endElem().</p>
 * <p>The endElem() must not have any arguments. However, the startElem() method
 * defines what attributes and inner elements the element can have.</p>
 * <p>Each argument of startElem() defines an XML attribute. It may be marked as
 * optional with the {@link Optional} annotation. The actual names of attributes
 * that are looked up in the XML file are specified by the {@link Attributes}
 * annotation. The type of the attribute is specified by the Java type of the
 * argument.</p>
 * <p>The {@link Contains} annotation specifies which kinds of elements are
 * contained in the annotated element. The {@link Contains#many()} attribute
 * determines how elements are repeated.</p>
 * <p>Using all these annotations, the application {@link MakeParserDTD} can
 * automatically generate the DTD for SDL files.</p>
 * <p>Similarly, the {@link Parser} class can automatically parse an SDL file,
 * taking default values into account.</p>
 * 
 * @author Antoine Cailliau <antoine.cailliau@uclouvain.be>
 * @author Julien Dupuis
 * @author Sébastien Doeraene <sjrdoeraene@gmail.com>
 */
public interface ParserHandler {
	@Contains({"Cameras", "Lights", "Geometry", "Textures?", "Materials?",
		"Scene"})
	public void startSdl() throws Exception;

	public void endSdl() throws Exception;

	@Contains(value = "Camera", many = OneToMany)
	public void startCameras() throws Exception;

	public void endCameras() throws Exception;

	@Attributes({"position", "direction", "up", "fovy", "name"})
	public void startCamera(Point3D position, Vector3D direction, Vector3D up,
			float fovy, String name) throws Exception;

	public void endCamera() throws Exception;

	@Contains(value = {"DirectionalLight", "PointLight", "SpotLight"},
			many = OneToMany)
	public void startLights() throws Exception;

	public void endLights() throws Exception;

	@Attributes({"direction", "intensity", "color", "name"})
	public void startDirectionalLight(Vector3D direction,
			@Optional("1") float intensity, @Optional("1 1 1") Color color,
			String name) throws Exception;

	public void endDirectionalLight() throws Exception;

	@Attributes({"position", "intensity", "color", "name"})
	public void startPointLight(Point3D position,
			@Optional("1") float intensity, @Optional("1 1 1") Color color,
			String name) throws Exception;

	public void endPointLight() throws Exception;

	@Attributes({"position", "direction", "angle", "intensity", "color",
		"name"})
	public void startSpotLight(Point3D position, Vector3D direction,
			float angle, @Optional("1") float intensity,
			@Optional("1 1 1") Color color, String name) throws Exception;

	public void endSpotLight() throws Exception;

	@Contains(value = {"Sphere", "Cylinder", "Cone", "Torus", "Teapot",
			"IndexedTriangleSet", "FileGeometry"},
			many = OneToMany)
	public void startGeometry() throws Exception;

	public void endGeometry() throws Exception;

	@Attributes({"radius", "name"})
	public void startSphere(float radius, String name) throws Exception;

	public void endSphere() throws Exception;

	@Attributes({"radius", "height", "capped", "name"})
	public void startCylinder(float radius, float height,
			@Optional("true") boolean capped, String name) throws Exception;

	public void endCylinder() throws Exception;

	@Attributes({"radius", "height", "capped", "name"})
	public void startCone(float radius, float height,
			@Optional("true") boolean capped, String name) throws Exception;

	public void endCone() throws Exception;

	@Attributes({"innerRadius", "outerRadius", "name"})
	public void startTorus(float innerRadius, float outerRadius, String name)
			throws Exception;

	public void endTorus() throws Exception;

	@Attributes({"size", "name"})
	public void startTeapot(float size, String name) throws Exception;

	public void endTeapot() throws Exception;

	@Attributes({"coordinates", "normals", "textureCoordinates",
		"coordinateIndices", "normalIndices", "textureCoordinateIndices",
		"name"})
	public void startIndexedTriangleSet(Point3D[] coordinates,
			@Optional Vector3D[] normals,
			@Optional TextureCoordinates[] textureCoordinates,
			int[] coordinateIndices, @Optional int[] normalIndices,
			@Optional int[] textureCoordinateIndices,
			String name) throws Exception;

	public void endIndexedTriangleSet() throws Exception;

	@Attributes({"filename", "name"})
	public void startFileGeometry(String filename, String name)
			throws Exception;

	public void endFileGeometry() throws Exception;

	@Contains(value = "Texture", many = ZeroToMany)
	public void startTextures() throws Exception;

	public void endTextures() throws Exception;

	@Attributes({"src", "name"})
	public void startTexture(String src, String name) throws Exception;

	public void endTexture() throws Exception;

	@Contains(value = {"DiffuseMaterial", "PhongMaterial",
			"LinearCombinedMaterial"},
			many = ZeroToMany)
	public void startMaterials() throws Exception;

	public void endMaterials() throws Exception;

	@Attributes({"color", "name"})
	public void startDiffuseMaterial(Color color, String name) throws Exception;

	public void endDiffuseMaterial() throws Exception;

	@Attributes({"color", "shininess", "name"})
	public void startPhongMaterial(Color color, float shininess, String name)
			throws Exception;

	public void endPhongMaterial() throws Exception;

	@Attributes({"material1", "weight1", "material2", "weight2", "name"})
	public void startLinearCombinedMaterial(@IDRef String material1Name,
			@Optional("0.5") float weight1, @IDRef String material2Name,
			@Optional("0.5") float weight2, String name) throws Exception;

	public void endLinearCombinedMaterial() throws Exception;

	@Attributes({"camera", "lights", "background"})
	@Contains(value = {"Shape", "Rotate", "Translate", "Scale"},
        many = OneToMany)
	public void startScene(@IDRef String cameraName, String[] lightNames,
			@Optional("0 0 0") Color background) throws Exception;

	public void endScene() throws Exception;

	@Attributes({"geometry", "material", "texture"})
	public void startShape(@IDRef String geometryName,
			@Optional @IDRef String materialName,
			@Optional @IDRef String textureName) throws Exception;

	public void endShape() throws Exception;

	@Attributes({"axis", "angle"})
	@Contains(value = {"Shape", "Rotate", "Translate", "Scale"},
			many = OneToMany)
	public void startRotate(Vector3D axis, float angle) throws Exception;

	public void endRotate() throws Exception;

	@Attributes({"vector"})
	@Contains(value = {"Shape", "Rotate", "Translate", "Scale"},
			many = OneToMany)
	public void startTranslate(Vector3D vector) throws Exception;

	public void endTranslate() throws Exception;

	@Attributes({"scale"})
	@Contains(value = {"Shape", "Rotate", "Translate", "Scale"},
			many = OneToMany)
	public void startScale(Vector3D scale) throws Exception;

	public void endScale() throws Exception;
}
