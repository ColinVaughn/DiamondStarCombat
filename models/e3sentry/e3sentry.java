// Made with Blockbench 4.6.5
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class e3sentry<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "e3sentry"), "main");
	private final ModelPart body;

	public e3sentry(ModelPart root) {
		this.body = root.getChild("body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition fuselage = body.addOrReplaceChild("fuselage", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition wing = fuselage.addOrReplaceChild("wing", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition left_wing = wing.addOrReplaceChild("left_wing", CubeListBuilder.create().texOffs(260, 307).addBox(-129.0F, -17.0F, -1.0F, 112.0F, 2.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition right_wing = wing.addOrReplaceChild("right_wing", CubeListBuilder.create().texOffs(260, 281).addBox(17.0F, -17.0F, -1.0F, 112.0F, 2.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition frame = fuselage.addOrReplaceChild("frame", CubeListBuilder.create().texOffs(0, 129).addBox(-16.0F, -11.0F, -64.0F, 32.0F, 1.0F, 128.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-16.0F, -44.0F, -64.0F, 32.0F, 1.0F, 128.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition wallL = frame.addOrReplaceChild("wallL", CubeListBuilder.create().texOffs(192, 141).addBox(-17.0F, -23.0F, -64.0F, 1.0F, 12.0F, 128.0F, new CubeDeformation(0.0F))
		.texOffs(130, 281).addBox(-17.0F, -43.0F, -64.0F, 1.0F, 8.0F, 128.0F, new CubeDeformation(0.0F))
		.texOffs(18, 193).addBox(-17.0F, -35.0F, -64.0F, 1.0F, 12.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 193).addBox(-17.0F, -35.0F, 8.0F, 1.0F, 12.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(192, 177).addBox(-17.0F, -35.0F, -16.0F, 1.0F, 12.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(192, 157).addBox(-17.0F, -35.0F, 56.0F, 1.0F, 12.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(192, 65).addBox(-17.0F, -35.0F, 32.0F, 1.0F, 12.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(192, 29).addBox(-17.0F, -35.0F, -40.0F, 1.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition wallR = frame.addOrReplaceChild("wallR", CubeListBuilder.create().texOffs(192, 1).addBox(16.0F, -23.0F, -64.0F, 1.0F, 12.0F, 128.0F, new CubeDeformation(0.0F))
		.texOffs(0, 258).addBox(16.0F, -43.0F, -64.0F, 1.0F, 8.0F, 128.0F, new CubeDeformation(0.0F))
		.texOffs(0, 129).addBox(16.0F, -35.0F, -64.0F, 1.0F, 12.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(104, 26).addBox(16.0F, -35.0F, 8.0F, 1.0F, 12.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(104, 0).addBox(16.0F, -35.0F, -16.0F, 1.0F, 12.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 52).addBox(16.0F, -35.0F, 56.0F, 1.0F, 12.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 26).addBox(16.0F, -35.0F, 32.0F, 1.0F, 12.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(16.0F, -35.0F, -40.0F, 1.0F, 12.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition nose = fuselage.addOrReplaceChild("nose", CubeListBuilder.create().texOffs(0, 52).addBox(-16.0F, -11.0F, 64.0F, 32.0F, 1.0F, 24.0F, new CubeDeformation(0.0F))
		.texOffs(192, 0).addBox(-8.0F, -23.0F, 88.0F, 16.0F, 13.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(192, 65).addBox(16.0F, -23.0F, 64.0F, 1.0F, 12.0F, 24.0F, new CubeDeformation(0.0F))
		.texOffs(192, 29).addBox(-17.0F, -23.0F, 64.0F, 1.0F, 12.0F, 24.0F, new CubeDeformation(0.0F))
		.texOffs(106, 129).addBox(-16.0F, -23.0F, 88.0F, 8.0F, 12.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(104, 52).addBox(8.0F, -23.0F, 88.0F, 8.0F, 12.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(18, 26).addBox(16.0F, -35.0F, 76.0F, 1.0F, 12.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(192, 101).addBox(16.0F, -43.0F, 64.0F, 1.0F, 8.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(28, 129).addBox(-16.0F, -44.0F, 64.0F, 32.0F, 1.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(52, 144).addBox(-16.0F, -43.0F, 63.0F, 32.0F, 32.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(88, 52).addBox(-17.0F, -43.0F, 64.0F, 1.0F, 8.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(18, 0).addBox(-17.0F, -35.0F, 76.0F, 1.0F, 12.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(66, 103).addBox(-8.0F, -44.0F, 78.0F, 16.0F, 1.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition tail = fuselage.addOrReplaceChild("tail", CubeListBuilder.create().texOffs(0, 77).addBox(-16.0F, -43.0F, 63.0F, 32.0F, 32.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(52, 177).addBox(-12.0F, -39.0F, 55.0F, 24.0F, 24.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(80, 77).addBox(-8.0F, -35.0F, 47.0F, 16.0F, 16.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(192, 141).addBox(-4.0F, -31.0F, 39.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 129).addBox(-1.0F, -71.0F, 44.0F, 2.0F, 40.0F, 24.0F, new CubeDeformation(0.0F))
		.texOffs(0, 26).addBox(4.0F, -28.0F, 44.0F, 40.0F, 2.0F, 24.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-44.0F, -28.0F, 44.0F, 40.0F, 2.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -135.0F));

		PartDefinition seat = body.addOrReplaceChild("seat", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition gear = body.addOrReplaceChild("gear", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition front = gear.addOrReplaceChild("front", CubeListBuilder.create().texOffs(88, 52).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(112, 171).addBox(1.0F, 4.0F, -3.0F, 2.0F, 6.0F, 6.0F, new CubeDeformation(0.0F))
		.texOffs(112, 101).addBox(-3.0F, 4.0F, -3.0F, 2.0F, 6.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -10.0F, 56.0F));

		PartDefinition propeller = body.addOrReplaceChild("propeller", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 1024, 1024);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}