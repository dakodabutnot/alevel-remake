package com.dakoda.alr.game.battle;
import com.dakoda.alr.game.exception.InvalidEquipSlotArgumentException;
import com.dakoda.alr.game.exception.NullEquipException;
import com.dakoda.alr.game.world.item.attribute.WeaponMaterial;
import com.dakoda.alr.game.world.item.attribute.WeaponType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import java.util.Arrays;
import java.util.Set;

import static com.dakoda.alr.game.world.item.Items.Weapon.IRON_SWORD;

@RunWith(JUnit4.class)
public class EquipmentTest {

    @Test
    public void test_constructor() {
        Equipment equipment = new Equipment();
        Set<ArmourEquipSlot> keySet = equipment.getArmour().keySet();
        Arrays.stream(ArmourEquipSlot.values())
                .forEach(slot -> Assert.assertTrue(keySet.contains(slot)));
    }

    @Test
    public void test_equip_armour_slotted() {
        ItemArmour itemTest = Items.Armour.IRON_HELMET.get();
        Equipment equipment = new Equipment();
        equipment.equipArmour(itemTest.getArmourEquipSlot(), itemTest);
        Assert.assertTrue(equipment.getArmour().containsValue(itemTest));
    }

    @Test
    public void test_equip_armour() {
        ItemArmour itemTest = Items.Armour.IRON_HELMET.get();
        Equipment equipment = new Equipment();
        equipment.equipArmour(itemTest);
        Assert.assertTrue(equipment.getArmour().containsValue(itemTest));
    }

    @Test
    public void test_equip_weapon_singleHanded_indeterminateHandChoice_currentEmptyHand() {
        ItemWeapon itemTest = IRON_SWORD.get();
        Equipment equipment = new Equipment();
        equipment.equipWeapon(itemTest);
        Assert.assertEquals(equipment.getWeapons().left(), itemTest);
    }

    @Test
    public void test_equip_weapon_singleHanded_indeterminateHandChoice_currentEquipped() {
        ItemWeapon itemTest = IRON_SWORD.get();
        Equipment equipment = new Equipment();
        equipment.equipWeapon(0, itemTest);
        equipment.equipWeapon(itemTest);
        Assert.assertEquals(equipment.getWeapons().right(), itemTest);
    }

    @Test
    public void test_equip_weapon_singleHanded_leftHandChoice() {
        ItemWeapon itemTest = IRON_SWORD.get();
        Equipment equipment = new Equipment();
        equipment.equipWeapon(0, itemTest);
        Assert.assertEquals(equipment.getWeapons().left(), itemTest);
    }

    @Test
    public void test_equip_weapon_singleHanded_rightHandChoice() {
        ItemWeapon itemTest = IRON_SWORD.get();
        Equipment equipment = new Equipment();
        equipment.equipWeapon(1, itemTest);
        Assert.assertEquals(equipment.getWeapons().right(), itemTest);
    }

    @Test(expected = NullEquipException.class)
    public void test_equip_weapon_null() {
        Equipment equipment = new Equipment();
        equipment.equipWeapon(null);
    }

    @Test(expected = NullEquipException.class)
    public void test_equip_weapon_null_handed() {
        Equipment equipment = new Equipment();
        equipment.equipWeapon(0, null);
    }

    @Test
    public void test_unequip_armour() {
        ItemArmour itemTest = Items.Armour.IRON_HELMET.get();
        Equipment equipment = new Equipment();
        equipment.equipArmour(itemTest.getArmourEquipSlot(), itemTest);
        equipment.unequipArmour(itemTest.getArmourEquipSlot());
        Assert.assertEquals(equipment.getArmour().get(itemTest.getArmourEquipSlot()), Items.Armour.EMPTY.get());
    }

    @Test
    public void test_unequip_weapon() {
        ItemWeapon itemTest = IRON_SWORD.get();
        Equipment equipment = new Equipment();
        equipment.equipWeapon(0, itemTest);
        equipment.unequipWeapon(0);
        Assert.assertEquals(Items.Weapon.EMPTY.get(), equipment.getWeapons().left());
    }

    @Test
    public void test_equip_weapon_doubleHanded_indeterminateHandChoice() {
        ItemWeapon itemTest = Items.Weapon.BOW.get();
        Equipment equipment = new Equipment();
        equipment.equipWeapon(itemTest);
        Assert.assertEquals(itemTest, equipment.getWeapons().left());
        Assert.assertEquals(itemTest, equipment.getWeapons().right());
    }

    @Test
    public void test_equip_weapon_doubleHanded_leftHand() {
        ItemWeapon itemTest = Items.Weapon.BOW.get();
        Equipment equipment = new Equipment();
        equipment.equipWeapon(0, itemTest);
        Assert.assertEquals(itemTest, equipment.getWeapons().left());
        Assert.assertEquals(itemTest, equipment.getWeapons().right());
    }

    @Test
    public void test_equip_weapon_doubleHanded_rightHand() {
        ItemWeapon itemTest = Items.Weapon.BOW.get();
        Equipment equipment = new Equipment();
        equipment.equipWeapon(1, itemTest);
        Assert.assertEquals(itemTest, equipment.getWeapons().left());
        Assert.assertEquals(itemTest, equipment.getWeapons().right());
    }

    @Test
    public void test_equip_weapon_singleHanded_equippedDoubleHanded_indeterminateHandChoice() {
        ItemWeapon itemTest = IRON_SWORD.get();
        Equipment equipment = new Equipment();
        equipment.equipWeapon(Items.Weapon.BOW.get());
        equipment.equipWeapon(itemTest);
        Assert.assertEquals(itemTest, equipment.getWeapons().left());
        Assert.assertEquals(Items.Weapon.EMPTY.get(), equipment.getWeapons().right());
    }

    @Test
    public void test_equip_weapon_singleHanded_equippedDoubleHanded_leftHand() {
        ItemWeapon itemTest = IRON_SWORD.get();
        Equipment equipment = new Equipment();
        equipment.equipWeapon(Items.Weapon.BOW.get());
        equipment.equipWeapon(0, itemTest);
        Assert.assertEquals(itemTest, equipment.getWeapons().left());
        Assert.assertEquals(Items.Weapon.EMPTY.get(), equipment.getWeapons().right());
    }

    @Test(expected = NullEquipException.class)
    public void test_equip_armour_null() {
        Equipment equipment = new Equipment();
        equipment.equipArmour(null);
    }

    @Test(expected = NullEquipException.class)
    public void test_equip_armour_null_slotted() {
        Equipment equipment = new Equipment();
        equipment.equipArmour(ArmourEquipSlot.HEAD, null);
    }

    @Test(expected = InvalidEquipSlotArgumentException.class)
    public void test_equip_armour_nullSlot() {
        ItemArmour itemTest = Items.Armour.IRON_HELMET.get();
        Equipment equipment = new Equipment();
        equipment.equipArmour(null, itemTest);
    }

    @Test(expected = InvalidEquipSlotArgumentException.class)
    public void test_equip_weapon_invalidSlot() {
        ItemWeapon itemTest = Items.Weapon.IRON_SWORD.get();
        Equipment equipment = new Equipment();
        equipment.equipWeapon(-1, itemTest);
    }

    @Test
    public void test_equip_weapon_singleHanded_currentlyEquippedTwo() {
        ItemWeapon itemTest = IRON_SWORD.get();
        ItemWeapon testWeapon = new ItemWeapon("test weapon", WeaponType.SWORD, WeaponMaterial.WOOD);
        Equipment equipment = new Equipment();
        equipment.equipWeapon(0, testWeapon);
        equipment.equipWeapon(1, itemTest);
        equipment.equipWeapon(itemTest);
        Assert.assertEquals(equipment.getWeapons().left(), itemTest);
    }

    @Test
    public void test_unequipArmour_withSpecificArmour() {
        ItemArmour itemTest = Items.Armour.IRON_HELMET.get();
        Equipment equipment = new Equipment();
        equipment.equipArmour(itemTest);
        equipment.unequipArmour(itemTest);
        Assert.assertEquals(equipment.getArmour().get(itemTest.getArmourEquipSlot()), Items.Armour.EMPTY.get());
    }

    @Test(expected = InvalidEquipSlotArgumentException.class)
    public void test_unequipArmour_withSpecificArmour_butNotEquipped() {
        ItemArmour itemTest = Items.Armour.IRON_HELMET.get();
        Equipment equipment = new Equipment();
        equipment.unequipArmour(itemTest);
    }
}
