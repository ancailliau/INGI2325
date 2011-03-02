package uclouvain.ingi2325.parser;

import uclouvain.ingi2325.utils.Color;
import uclouvain.ingi2325.utils.Point3D;
import uclouvain.ingi2325.utils.TextureCoordinates;
import uclouvain.ingi2325.utils.Vector3D;

/**
 * Interface for handlers. This interface defines for each tag in our SDL a
 * start- and an end-method.
 * 
 * @author Antoine Cailliau <antoine.cailliau@uclouvain.be>
 * @author Julien Dupuis
 */
public interface ParserHandler {
	public void startSdl() throws Exception;

	public void endSdl() throws Exception;

	public void startCameras() throws Exception;

	public void endCameras() throws Exception;

	public void startCamera(Point3D position, Vector3D direction, Vector3D up,
			float fovy, String name) throws Exception;

	public void endCamera() throws Exception;

	public void startLights() throws Exception;

	public void endLights() throws Exception;

	public void startDirectionalLight(Vector3D direction, float intensity,
			Color color, String name) throws Exception;

	public void endDirectionalLight() throws Exception;

	public void startPointLight(Point3D position, float intensity, Color color,
			String name) throws Exception;

	public void endPointLight() throws Exception;

	public void startSpotLight(Point3D position, Vector3D direction,
			float angle, float intensity, Color color, String name)
			throws Exception;

	public void endSpotLight() throws Exception;

	public void startGeometry() throws Exception;

	public void endGeometry() throws Exception;

	public void startSphere(float radius, String name) throws Exception;

	public void endSphere() throws Exception;

	public void startCylinder(float radius, float height, boolean capped,
			String name) throws Exception;

	public void endCylinder() throws Exception;

	public void startCone(float radius, float height, boolean capped,
			String name) throws Exception;

	public void endCone() throws Exception;

	public void startTorus(float innerRadius, float outerRadius, String name)
			throws Exception;

	public void endTorus() throws Exception;

	public void startTeapot(float size, String name) throws Exception;

	public void endTeapot() throws Exception;

	public void startIndexedTriangleSet(Point3D[] coordinates,
			Vector3D[] normals, TextureCoordinates[] textureCoordinates,
			int[] coordinateIndices, int[] normalIndices,
			int[] textureCoordinateIndices, String name) throws Exception;

	public void endIndexedTriangleSet() throws Exception;

	public void startFileGeometry(String filename, String name)
			throws Exception;

	public void endFileGeometry() throws Exception;

	public void startTextures() throws Exception;

	public void endTextures() throws Exception;

	public void startTexture(String src, String name) throws Exception;

	public void endTexture() throws Exception;

	public void startMaterials() throws Exception;

	public void endMaterials() throws Exception;

	public void startDiffuseMaterial(Color color, String name) throws Exception;

	public void endDiffuseMaterial() throws Exception;

	public void startPhongMaterial(Color color, float shininess, String name)
			throws Exception;

	public void endPhongMaterial() throws Exception;

	public void startLinearCombinedMaterial(String material1Name,
			float weight1, String material2Name, float weight2, String name)
			throws Exception;

	public void endLinearCombinedMaterial() throws Exception;

	public void startScene(String cameraName, String[] lightNames,
			Color background) throws Exception;

	public void endScene() throws Exception;

	public void startShape(String geometryName, String materialName,
			String textureName) throws Exception;

	public void endShape() throws Exception;

	public void startRotate(Vector3D axis, float angle) throws Exception;

	public void endRotate() throws Exception;

	public void startTranslate(Vector3D vector) throws Exception;

	public void endTranslate() throws Exception;

	public void startScale(Vector3D scale) throws Exception;

	public void endScale() throws Exception;
}
