/**
 * ResearchSpace
 * Copyright (C) 2020, © Trustees of the British Museum
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.researchspace;

import com.bigdata.rdf.vocab.BaseVocabularyDecl;

public class ResearchSpaceVocabularyDecl extends BaseVocabularyDecl {
	public ResearchSpaceVocabularyDecl() {
		super(
				// Namespace
				"http://www.cidoc-crm.org/cidoc-crm/",

				// Classes
				"http://www.cidoc-crm.org/cidoc-crm/E1_CRM_Entity",
				"http://www.cidoc-crm.org/cidoc-crm/E2_Temporal_Entity",
				"http://www.cidoc-crm.org/cidoc-crm/E3_Condition_State", "http://www.cidoc-crm.org/cidoc-crm/E4_Period",
				"http://www.cidoc-crm.org/cidoc-crm/E5_Event", "http://www.cidoc-crm.org/cidoc-crm/E6_Destruction",
				"http://www.cidoc-crm.org/cidoc-crm/E7_Activity", "http://www.cidoc-crm.org/cidoc-crm/E8_Acquisition",
				"http://www.cidoc-crm.org/cidoc-crm/E9_Move",
				"http://www.cidoc-crm.org/cidoc-crm/E10_Transfer_of_Custody",
				"http://www.cidoc-crm.org/cidoc-crm/E11_Modification",
				"http://www.cidoc-crm.org/cidoc-crm/E12_Production",
				"http://www.cidoc-crm.org/cidoc-crm/E13_Attribute_Assignment",
				"http://www.cidoc-crm.org/cidoc-crm/E14_Condition_Assessment",
				"http://www.cidoc-crm.org/cidoc-crm/E15_Identifier_Assignment",
				"http://www.cidoc-crm.org/cidoc-crm/E16_Measurement",
				"http://www.cidoc-crm.org/cidoc-crm/E17_Type_Assignment",
				"http://www.cidoc-crm.org/cidoc-crm/E18_Physical_Thing",
				"http://www.cidoc-crm.org/cidoc-crm/E19_Physical_Object",
				"http://www.cidoc-crm.org/cidoc-crm/E20_Biological_Object",
				"http://www.cidoc-crm.org/cidoc-crm/E21_Person",
				"http://www.cidoc-crm.org/cidoc-crm/E22_Man-Made_Object",
				"http://www.cidoc-crm.org/cidoc-crm/E24_Physical_Man-Made_Thing",
				"http://www.cidoc-crm.org/cidoc-crm/E25_Man-Made_Feature",
				"http://www.cidoc-crm.org/cidoc-crm/E26_Physical_Feature",
				"http://www.cidoc-crm.org/cidoc-crm/E27_Site",
				"http://www.cidoc-crm.org/cidoc-crm/E28_Conceptual_Object",
				"http://www.cidoc-crm.org/cidoc-crm/E29_Design_or_Procedure",
				"http://www.cidoc-crm.org/cidoc-crm/E30_Right", "http://www.cidoc-crm.org/cidoc-crm/E31_Document",
				"http://www.cidoc-crm.org/cidoc-crm/E32_Authority_Document",
				"http://www.cidoc-crm.org/cidoc-crm/E33_Linguistic_Object",
				"http://www.cidoc-crm.org/cidoc-crm/E34_Inscription", "http://www.cidoc-crm.org/cidoc-crm/E35_Title",
				"http://www.cidoc-crm.org/cidoc-crm/E36_Visual_Item", "http://www.cidoc-crm.org/cidoc-crm/E37_Mark",
				"http://www.cidoc-crm.org/cidoc-crm/E38_Image", "http://www.cidoc-crm.org/cidoc-crm/E39_Actor",
				"http://www.cidoc-crm.org/cidoc-crm/E40_Legal_Body",
				"http://www.cidoc-crm.org/cidoc-crm/E41_Appellation",
				"http://www.cidoc-crm.org/cidoc-crm/E42_Identifier",
				"http://www.cidoc-crm.org/cidoc-crm/E44_Place_Appellation",
				"http://www.cidoc-crm.org/cidoc-crm/E45_Address",
				"http://www.cidoc-crm.org/cidoc-crm/E46_Section_Definition",
				"http://www.cidoc-crm.org/cidoc-crm/E47_Spatial_Coordinates",
				"http://www.cidoc-crm.org/cidoc-crm/E48_Place_Name",
				"http://www.cidoc-crm.org/cidoc-crm/E49_Time_Appellation",
				"http://www.cidoc-crm.org/cidoc-crm/E50_Date", "http://www.cidoc-crm.org/cidoc-crm/E51_Contact_Point",
				"http://www.cidoc-crm.org/cidoc-crm/E52_Time-Span", "http://www.cidoc-crm.org/cidoc-crm/E53_Place",
				"http://www.cidoc-crm.org/cidoc-crm/E54_Dimension", "http://www.cidoc-crm.org/cidoc-crm/E55_Type",
				"http://www.cidoc-crm.org/cidoc-crm/E56_Language", "http://www.cidoc-crm.org/cidoc-crm/E57_Material",
				"http://www.cidoc-crm.org/cidoc-crm/E58_Measurement_Unit",
				"http://www.cidoc-crm.org/cidoc-crm/E63_Beginning_of_Existence",
				"http://www.cidoc-crm.org/cidoc-crm/E64_End_of_Existence",
				"http://www.cidoc-crm.org/cidoc-crm/E65_Creation", "http://www.cidoc-crm.org/cidoc-crm/E66_Formation",
				"http://www.cidoc-crm.org/cidoc-crm/E67_Birth", "http://www.cidoc-crm.org/cidoc-crm/E68_Dissolution",
				"http://www.cidoc-crm.org/cidoc-crm/E69_Death", "http://www.cidoc-crm.org/cidoc-crm/E70_Thing",
				"http://www.cidoc-crm.org/cidoc-crm/E71_Man-Made_Thing",
				"http://www.cidoc-crm.org/cidoc-crm/E72_Legal_Object",
				"http://www.cidoc-crm.org/cidoc-crm/E73_Information_Object",
				"http://www.cidoc-crm.org/cidoc-crm/E74_Group",
				"http://www.cidoc-crm.org/cidoc-crm/E75_Conceptual_Object_Appellation",
				"http://www.cidoc-crm.org/cidoc-crm/E77_Persistent_Item",
				"http://www.cidoc-crm.org/cidoc-crm/E78_Collection",
				"http://www.cidoc-crm.org/cidoc-crm/E79_Part_Addition",
				"http://www.cidoc-crm.org/cidoc-crm/E80_Part_Removal",
				"http://www.cidoc-crm.org/cidoc-crm/E81_Transformation",
				"http://www.cidoc-crm.org/cidoc-crm/E82_Actor_Appellation",
				"http://www.cidoc-crm.org/cidoc-crm/E83_Type_Creation",
				"http://www.cidoc-crm.org/cidoc-crm/E84_Information_Carrier",
				"http://www.cidoc-crm.org/cidoc-crm/E85_Joining", "http://www.cidoc-crm.org/cidoc-crm/E86_Leaving",
				"http://www.cidoc-crm.org/cidoc-crm/E87_Curation_Activity",
				"http://www.cidoc-crm.org/cidoc-crm/E89_Propositional_Object",
				"http://www.cidoc-crm.org/cidoc-crm/E90_Symbolic_Object",
				"http://www.cidoc-crm.org/cidoc-crm/E92_Spacetime_Volume",
				"http://www.cidoc-crm.org/cidoc-crm/E93_Presence",
				"http://www.cidoc-crm.org/cidoc-crm/E94_Space_Primitive",
				"http://www.cidoc-crm.org/cidoc-crm/E95_Spacetime_Primitive",
				"http://www.cidoc-crm.org/cidoc-crm/E96_Purchase",
				"http://www.cidoc-crm.org/cidoc-crm/E97_Monetary_Amount",
				"http://www.cidoc-crm.org/cidoc-crm/E98_Currency",
				"http://www.cidoc-crm.org/cidoc-crm/E99_Product_Type",

				// Properties
				"http://www.cidoc-crm.org/cidoc-crm/P1i_identifies",
				"http://www.cidoc-crm.org/cidoc-crm/P1_is_identified_by",
				"http://www.cidoc-crm.org/cidoc-crm/P2i_is_type_of", "http://www.cidoc-crm.org/cidoc-crm/P2_has_type",
				"http://www.cidoc-crm.org/cidoc-crm/P3_has_note",
				"http://www.cidoc-crm.org/cidoc-crm/P4i_is_time-span_of",
				"http://www.cidoc-crm.org/cidoc-crm/P4_has_time-span",
				"http://www.cidoc-crm.org/cidoc-crm/P5_consists_of",
				"http://www.cidoc-crm.org/cidoc-crm/P5i_forms_part_of",
				"http://www.cidoc-crm.org/cidoc-crm/P7i_witnessed",
				"http://www.cidoc-crm.org/cidoc-crm/P7_took_place_at",
				"http://www.cidoc-crm.org/cidoc-crm/P8i_witnessed",
				"http://www.cidoc-crm.org/cidoc-crm/P8_took_place_on_or_within",
				"http://www.cidoc-crm.org/cidoc-crm/P9_consists_of",
				"http://www.cidoc-crm.org/cidoc-crm/P9i_forms_part_of",
				"http://www.cidoc-crm.org/cidoc-crm/P10_falls_within",
				"http://www.cidoc-crm.org/cidoc-crm/P10i_contains",
				"http://www.cidoc-crm.org/cidoc-crm/P11i_participated_in",
				"http://www.cidoc-crm.org/cidoc-crm/P11_had_participant",
				"http://www.cidoc-crm.org/cidoc-crm/P12_occurred_in_the_presence_of",
				"http://www.cidoc-crm.org/cidoc-crm/P12i_was_present_at",
				"http://www.cidoc-crm.org/cidoc-crm/P13_destroyed",
				"http://www.cidoc-crm.org/cidoc-crm/P13i_was_destroyed_by",
				"http://www.cidoc-crm.org/cidoc-crm/P14i_performed",
				"http://www.cidoc-crm.org/cidoc-crm/P14_carried_out_by",
				"http://www.cidoc-crm.org/cidoc-crm/P15_was_influenced_by",
				"http://www.cidoc-crm.org/cidoc-crm/P15i_influenced",
				"http://www.cidoc-crm.org/cidoc-crm/P16_used_specific_object",
				"http://www.cidoc-crm.org/cidoc-crm/P16i_was_used_for",
				"http://www.cidoc-crm.org/cidoc-crm/P17_was_motivated_by",
				"http://www.cidoc-crm.org/cidoc-crm/P17i_motivated",
				"http://www.cidoc-crm.org/cidoc-crm/P19_was_intended_use_of",
				"http://www.cidoc-crm.org/cidoc-crm/P19i_was_made_for",
				"http://www.cidoc-crm.org/cidoc-crm/P20_had_specific_purpose",
				"http://www.cidoc-crm.org/cidoc-crm/P20i_was_purpose_of",
				"http://www.cidoc-crm.org/cidoc-crm/P21_had_general_purpose",
				"http://www.cidoc-crm.org/cidoc-crm/P21i_was_purpose_of",
				"http://www.cidoc-crm.org/cidoc-crm/P22_transferred_title_to",
				"http://www.cidoc-crm.org/cidoc-crm/P22i_acquired_title_through",
				"http://www.cidoc-crm.org/cidoc-crm/P23_transferred_title_from",
				"http://www.cidoc-crm.org/cidoc-crm/P23i_surrendered_title_through",
				"http://www.cidoc-crm.org/cidoc-crm/P24_transferred_title_of",
				"http://www.cidoc-crm.org/cidoc-crm/P24i_changed_ownership_through",
				"http://www.cidoc-crm.org/cidoc-crm/P25_moved", "http://www.cidoc-crm.org/cidoc-crm/P25i_moved_by",
				"http://www.cidoc-crm.org/cidoc-crm/P26_moved_to",
				"http://www.cidoc-crm.org/cidoc-crm/P26i_was_destination_of",
				"http://www.cidoc-crm.org/cidoc-crm/P27_moved_from",
				"http://www.cidoc-crm.org/cidoc-crm/P27i_was_origin_of",
				"http://www.cidoc-crm.org/cidoc-crm/P28_custody_surrendered_by",
				"http://www.cidoc-crm.org/cidoc-crm/P28i_surrendered_custody_through",
				"http://www.cidoc-crm.org/cidoc-crm/P29_custody_received_by",
				"http://www.cidoc-crm.org/cidoc-crm/P29i_received_custody_through",
				"http://www.cidoc-crm.org/cidoc-crm/P30_transferred_custody_of",
				"http://www.cidoc-crm.org/cidoc-crm/P30i_custody_transferred_through",
				"http://www.cidoc-crm.org/cidoc-crm/P31_has_modified",
				"http://www.cidoc-crm.org/cidoc-crm/P31i_was_modified_by",
				"http://www.cidoc-crm.org/cidoc-crm/P32_used_general_technique",
				"http://www.cidoc-crm.org/cidoc-crm/P32i_was_technique_of",
				"http://www.cidoc-crm.org/cidoc-crm/P33_used_specific_technique",
				"http://www.cidoc-crm.org/cidoc-crm/P33i_was_used_by",
				"http://www.cidoc-crm.org/cidoc-crm/P34_concerned",
				"http://www.cidoc-crm.org/cidoc-crm/P34i_was_assessed_by",
				"http://www.cidoc-crm.org/cidoc-crm/P35_has_identified",
				"http://www.cidoc-crm.org/cidoc-crm/P35i_was_identified_by",
				"http://www.cidoc-crm.org/cidoc-crm/P37_assigned",
				"http://www.cidoc-crm.org/cidoc-crm/P37i_was_assigned_by",
				"http://www.cidoc-crm.org/cidoc-crm/P38_deassigned",
				"http://www.cidoc-crm.org/cidoc-crm/P38i_was_deassigned_by",
				"http://www.cidoc-crm.org/cidoc-crm/P39_measured",
				"http://www.cidoc-crm.org/cidoc-crm/P39i_was_measured_by",
				"http://www.cidoc-crm.org/cidoc-crm/P40_observed_dimension",
				"http://www.cidoc-crm.org/cidoc-crm/P40i_was_observed_in",
				"http://www.cidoc-crm.org/cidoc-crm/P41_classified",
				"http://www.cidoc-crm.org/cidoc-crm/P41i_was_classified_by",
				"http://www.cidoc-crm.org/cidoc-crm/P42_assigned",
				"http://www.cidoc-crm.org/cidoc-crm/P42i_was_assigned_by",
				"http://www.cidoc-crm.org/cidoc-crm/P43_has_dimension",
				"http://www.cidoc-crm.org/cidoc-crm/P43i_is_dimension_of",
				"http://www.cidoc-crm.org/cidoc-crm/P44_has_condition",
				"http://www.cidoc-crm.org/cidoc-crm/P44i_is_condition_of",
				"http://www.cidoc-crm.org/cidoc-crm/P45_consists_of",
				"http://www.cidoc-crm.org/cidoc-crm/P45i_is_incorporated_in",
				"http://www.cidoc-crm.org/cidoc-crm/P46_is_composed_of",
				"http://www.cidoc-crm.org/cidoc-crm/P46i_forms_part_of",
				"http://www.cidoc-crm.org/cidoc-crm/P48_has_preferred_identifier",
				"http://www.cidoc-crm.org/cidoc-crm/P48i_is_preferred_identifier_of",
				"http://www.cidoc-crm.org/cidoc-crm/P49_has_former_or_current_keeper",
				"http://www.cidoc-crm.org/cidoc-crm/P49i_is_former_or_current_keeper_of",
				"http://www.cidoc-crm.org/cidoc-crm/P50_has_current_keeper",
				"http://www.cidoc-crm.org/cidoc-crm/P50i_is_current_keeper_of",
				"http://www.cidoc-crm.org/cidoc-crm/P51_has_former_or_current_owner",
				"http://www.cidoc-crm.org/cidoc-crm/P51i_is_former_or_current_owner_of",
				"http://www.cidoc-crm.org/cidoc-crm/P52_has_current_owner",
				"http://www.cidoc-crm.org/cidoc-crm/P52i_is_current_owner_of",
				"http://www.cidoc-crm.org/cidoc-crm/P53i_is_former_or_current_location_of",
				"http://www.cidoc-crm.org/cidoc-crm/P53_has_former_or_current_location",
				"http://www.cidoc-crm.org/cidoc-crm/P54_has_current_permanent_location",
				"http://www.cidoc-crm.org/cidoc-crm/P54i_is_current_permanent_location_of",
				"http://www.cidoc-crm.org/cidoc-crm/P55_has_current_location",
				"http://www.cidoc-crm.org/cidoc-crm/P55i_currently_holds",
				"http://www.cidoc-crm.org/cidoc-crm/P56_bears_feature",
				"http://www.cidoc-crm.org/cidoc-crm/P56i_is_found_on",
				"http://www.cidoc-crm.org/cidoc-crm/P57_has_number_of_parts",
				"http://www.cidoc-crm.org/cidoc-crm/P58_has_section_definition",
				"http://www.cidoc-crm.org/cidoc-crm/P58i_defines_section",
				"http://www.cidoc-crm.org/cidoc-crm/P59_has_section",
				"http://www.cidoc-crm.org/cidoc-crm/P59i_is_located_on_or_within",
				"http://www.cidoc-crm.org/cidoc-crm/P62_depicts",
				"http://www.cidoc-crm.org/cidoc-crm/P62i_is_depicted_by",
				"http://www.cidoc-crm.org/cidoc-crm/P65_shows_visual_item",
				"http://www.cidoc-crm.org/cidoc-crm/P65i_is_shown_by",
				"http://www.cidoc-crm.org/cidoc-crm/P67_refers_to",
				"http://www.cidoc-crm.org/cidoc-crm/P67i_is_referred_to_by",
				"http://www.cidoc-crm.org/cidoc-crm/P68_foresees_use_of",
				"http://www.cidoc-crm.org/cidoc-crm/P68i_use_foreseen_by",
				"http://www.cidoc-crm.org/cidoc-crm/P69_is_associated_with",
				"http://www.cidoc-crm.org/cidoc-crm/P70_documents",
				"http://www.cidoc-crm.org/cidoc-crm/P70i_is_documented_in",
				"http://www.cidoc-crm.org/cidoc-crm/P71_lists", "http://www.cidoc-crm.org/cidoc-crm/P71i_is_listed_in",
				"http://www.cidoc-crm.org/cidoc-crm/P72_has_language",
				"http://www.cidoc-crm.org/cidoc-crm/P72i_is_language_of",
				"http://www.cidoc-crm.org/cidoc-crm/P73_has_translation",
				"http://www.cidoc-crm.org/cidoc-crm/P73i_is_translation_of",
				"http://www.cidoc-crm.org/cidoc-crm/P74_has_current_or_former_residence",
				"http://www.cidoc-crm.org/cidoc-crm/P74i_is_current_or_former_residence_of",
				"http://www.cidoc-crm.org/cidoc-crm/P75_possesses",
				"http://www.cidoc-crm.org/cidoc-crm/P75i_is_possessed_by",
				"http://www.cidoc-crm.org/cidoc-crm/P76_has_contact_point",
				"http://www.cidoc-crm.org/cidoc-crm/P76i_provides_access_to",
				"http://www.cidoc-crm.org/cidoc-crm/P78_is_identified_by",
				"http://www.cidoc-crm.org/cidoc-crm/P78i_identifies",
				"http://www.cidoc-crm.org/cidoc-crm/P79_beginning_is_qualified_by",
				"http://www.cidoc-crm.org/cidoc-crm/P80_end_is_qualified_by",
				"http://www.cidoc-crm.org/cidoc-crm/P81_ongoing_throughout",
				"http://www.cidoc-crm.org/cidoc-crm/P81a_end_of_the_begin",
				"http://www.cidoc-crm.org/cidoc-crm/P81b_begin_of_the_end",
				"http://www.cidoc-crm.org/cidoc-crm/P82_at_some_time_within",
				"http://www.cidoc-crm.org/cidoc-crm/P83_had_at_least_duration",
				"http://www.cidoc-crm.org/cidoc-crm/P83i_was_minimum_duration_of",
				"http://www.cidoc-crm.org/cidoc-crm/P84_had_at_most_duration",
				"http://www.cidoc-crm.org/cidoc-crm/P84i_was_maximum_duration_of",
				"http://www.cidoc-crm.org/cidoc-crm/P86_falls_within",
				"http://www.cidoc-crm.org/cidoc-crm/P86i_contains",
				"http://www.cidoc-crm.org/cidoc-crm/P87_is_identified_by",
				"http://www.cidoc-crm.org/cidoc-crm/P87i_identifies",
				"http://www.cidoc-crm.org/cidoc-crm/P89_falls_within",
				"http://www.cidoc-crm.org/cidoc-crm/P89i_contains", "http://www.cidoc-crm.org/cidoc-crm/P90_has_value",
				"http://www.cidoc-crm.org/cidoc-crm/P91_has_unit", "http://www.cidoc-crm.org/cidoc-crm/P91i_is_unit_of",
				"http://www.cidoc-crm.org/cidoc-crm/P92_brought_into_existence",
				"http://www.cidoc-crm.org/cidoc-crm/P92i_was_brought_into_existence_by",
				"http://www.cidoc-crm.org/cidoc-crm/P93_took_out_of_existence",
				"http://www.cidoc-crm.org/cidoc-crm/P93i_was_taken_out_of_existence_by",
				"http://www.cidoc-crm.org/cidoc-crm/P94i_was_created_by",
				"http://www.cidoc-crm.org/cidoc-crm/P95_has_formed",
				"http://www.cidoc-crm.org/cidoc-crm/P95i_was_formed_by",
				"http://www.cidoc-crm.org/cidoc-crm/P96_by_mother",
				"http://www.cidoc-crm.org/cidoc-crm/P96i_gave_birth",
				"http://www.cidoc-crm.org/cidoc-crm/P97_from_father",
				"http://www.cidoc-crm.org/cidoc-crm/P97i_was_father_for",
				"http://www.cidoc-crm.org/cidoc-crm/P98_brought_into_life",
				"http://www.cidoc-crm.org/cidoc-crm/P98i_was_born", "http://www.cidoc-crm.org/cidoc-crm/P99_dissolved",
				"http://www.cidoc-crm.org/cidoc-crm/P99i_was_dissolved_by",
				"http://www.cidoc-crm.org/cidoc-crm/P100_was_death_of",
				"http://www.cidoc-crm.org/cidoc-crm/P100i_died_in",
				"http://www.cidoc-crm.org/cidoc-crm/P101_had_as_general_use",
				"http://www.cidoc-crm.org/cidoc-crm/P101i_was_use_of",
				"http://www.cidoc-crm.org/cidoc-crm/P138_represents",
				"http://www.cidoc-crm.org/cidoc-crm/P82a_begin_of_the_begin",
				"http://www.cidoc-crm.org/cidoc-crm/P82b_end_of_the_end",
				"http://www.cidoc-crm.org/cidoc-crm/P94_has_created",
				"http://www.cidoc-crm.org/cidoc-crm/P102_has_title",
				"http://www.cidoc-crm.org/cidoc-crm/P102i_is_title_of",
				"http://www.cidoc-crm.org/cidoc-crm/P103_was_intended_for",
				"http://www.cidoc-crm.org/cidoc-crm/P103i_was_intention_of",
				"http://www.cidoc-crm.org/cidoc-crm/P104_is_subject_to",
				"http://www.cidoc-crm.org/cidoc-crm/P104i_applies_to",
				"http://www.cidoc-crm.org/cidoc-crm/P105_right_held_by",
				"http://www.cidoc-crm.org/cidoc-crm/P105i_has_right_on",
				"http://www.cidoc-crm.org/cidoc-crm/P106_is_composed_of",
				"http://www.cidoc-crm.org/cidoc-crm/P106i_forms_part_of",
				"http://www.cidoc-crm.org/cidoc-crm/P107_has_current_or_former_member",
				"http://www.cidoc-crm.org/cidoc-crm/P107i_is_current_or_former_member_of",
				"http://www.cidoc-crm.org/cidoc-crm/P108_has_produced",
				"http://www.cidoc-crm.org/cidoc-crm/P108i_was_produced_by",
				"http://www.cidoc-crm.org/cidoc-crm/P109_has_current_or_former_curator",
				"http://www.cidoc-crm.org/cidoc-crm/P109i_is_current_or_former_curator_of",
				"http://www.cidoc-crm.org/cidoc-crm/P110_augmented",
				"http://www.cidoc-crm.org/cidoc-crm/P110i_was_augmented_by",
				"http://www.cidoc-crm.org/cidoc-crm/P111_added",
				"http://www.cidoc-crm.org/cidoc-crm/P111i_was_added_by",
				"http://www.cidoc-crm.org/cidoc-crm/P112_diminished",
				"http://www.cidoc-crm.org/cidoc-crm/P112i_was_diminished_by",
				"http://www.cidoc-crm.org/cidoc-crm/P113_removed",
				"http://www.cidoc-crm.org/cidoc-crm/P113i_was_removed_by",
				"http://www.cidoc-crm.org/cidoc-crm/P114_is_equal_in_time_to",
				"http://www.cidoc-crm.org/cidoc-crm/P115_finishes",
				"http://www.cidoc-crm.org/cidoc-crm/P115i_is_finished_by",
				"http://www.cidoc-crm.org/cidoc-crm/P116_starts",
				"http://www.cidoc-crm.org/cidoc-crm/P116i_is_started_by",
				"http://www.cidoc-crm.org/cidoc-crm/P117_occurs_during",
				"http://www.cidoc-crm.org/cidoc-crm/P117i_includes",
				"http://www.cidoc-crm.org/cidoc-crm/P118_overlaps_in_time_with",
				"http://www.cidoc-crm.org/cidoc-crm/P118i_is_overlapped_in_time_by",
				"http://www.cidoc-crm.org/cidoc-crm/P119_meets_in_time_with",
				"http://www.cidoc-crm.org/cidoc-crm/P119i_is_met_in_time_by",
				"http://www.cidoc-crm.org/cidoc-crm/P120_occurs_before",
				"http://www.cidoc-crm.org/cidoc-crm/P120i_occurs_after",
				"http://www.cidoc-crm.org/cidoc-crm/P121_overlaps_with",
				"http://www.cidoc-crm.org/cidoc-crm/P122_borders_with",
				"http://www.cidoc-crm.org/cidoc-crm/P123_resulted_in",
				"http://www.cidoc-crm.org/cidoc-crm/P123i_resulted_from",
				"http://www.cidoc-crm.org/cidoc-crm/P124_transformed",
				"http://www.cidoc-crm.org/cidoc-crm/P124i_was_transformed_by",
				"http://www.cidoc-crm.org/cidoc-crm/P125_used_object_of_type",
				"http://www.cidoc-crm.org/cidoc-crm/P125i_was_type_of_object_used_in",
				"http://www.cidoc-crm.org/cidoc-crm/P126_employed",
				"http://www.cidoc-crm.org/cidoc-crm/P126i_was_employed_in",
				"http://www.cidoc-crm.org/cidoc-crm/P127_has_broader_term",
				"http://www.cidoc-crm.org/cidoc-crm/P127i_has_narrower_term",
				"http://www.cidoc-crm.org/cidoc-crm/P128_carries",
				"http://www.cidoc-crm.org/cidoc-crm/P128i_is_carried_by",
				"http://www.cidoc-crm.org/cidoc-crm/P129_is_about",
				"http://www.cidoc-crm.org/cidoc-crm/P129i_is_subject_of",
				"http://www.cidoc-crm.org/cidoc-crm/P130_shows_features_of",
				"http://www.cidoc-crm.org/cidoc-crm/P130i_features_are_also_found_on",
				"http://www.cidoc-crm.org/cidoc-crm/P131_is_identified_by",
				"http://www.cidoc-crm.org/cidoc-crm/P131i_identifies",
				"http://www.cidoc-crm.org/cidoc-crm/P132_overlaps_with",
				"http://www.cidoc-crm.org/cidoc-crm/P133_is_separated_from",
				"http://www.cidoc-crm.org/cidoc-crm/P134_continued",
				"http://www.cidoc-crm.org/cidoc-crm/P134i_was_continued_by",
				"http://www.cidoc-crm.org/cidoc-crm/P135_created_type",
				"http://www.cidoc-crm.org/cidoc-crm/P135i_was_created_by",
				"http://www.cidoc-crm.org/cidoc-crm/P136_was_based_on",
				"http://www.cidoc-crm.org/cidoc-crm/P136i_supported_type_creation",
				"http://www.cidoc-crm.org/cidoc-crm/P137_exemplifies",
				"http://www.cidoc-crm.org/cidoc-crm/P137i_is_exemplified_by",
				"http://www.cidoc-crm.org/cidoc-crm/P138i_has_representation",
				"http://www.cidoc-crm.org/cidoc-crm/P139_has_alternative_form",
				"http://www.cidoc-crm.org/cidoc-crm/P140_assigned_attribute_to",
				"http://www.cidoc-crm.org/cidoc-crm/P140i_was_attributed_by",
				"http://www.cidoc-crm.org/cidoc-crm/P141_assigned",
				"http://www.cidoc-crm.org/cidoc-crm/P141i_was_assigned_by",
				"http://www.cidoc-crm.org/cidoc-crm/P142i_was_used_in",
				"http://www.cidoc-crm.org/cidoc-crm/P142_used_constituent",
				"http://www.cidoc-crm.org/cidoc-crm/P143_joined",
				"http://www.cidoc-crm.org/cidoc-crm/P143i_was_joined_by",
				"http://www.cidoc-crm.org/cidoc-crm/P144_joined_with",
				"http://www.cidoc-crm.org/cidoc-crm/P144i_gained_member_by",
				"http://www.cidoc-crm.org/cidoc-crm/P145_separated", "http://www.cidoc-crm.org/cidoc-crm/P145i_left_by",
				"http://www.cidoc-crm.org/cidoc-crm/P146_separated_from",
				"http://www.cidoc-crm.org/cidoc-crm/P146i_lost_member_by",
				"http://www.cidoc-crm.org/cidoc-crm/P147_curated",
				"http://www.cidoc-crm.org/cidoc-crm/P147i_was_curated_by",
				"http://www.cidoc-crm.org/cidoc-crm/P148_has_component",
				"http://www.cidoc-crm.org/cidoc-crm/P148i_is_component_of",
				"http://www.cidoc-crm.org/cidoc-crm/P149_is_identified_by",
				"http://www.cidoc-crm.org/cidoc-crm/P149i_identifies",
				"http://www.cidoc-crm.org/cidoc-crm/P150_defines_typical_parts_of",
				"http://www.cidoc-crm.org/cidoc-crm/P150i_defines_typical_wholes_for",
				"http://www.cidoc-crm.org/cidoc-crm/P151_was_formed_from",
				"http://www.cidoc-crm.org/cidoc-crm/P151i_participated_in",
				"http://www.cidoc-crm.org/cidoc-crm/P152_has_parent",
				"http://www.cidoc-crm.org/cidoc-crm/P152i_is_parent_of",
				"http://www.cidoc-crm.org/cidoc-crm/P156_occupies",
				"http://www.cidoc-crm.org/cidoc-crm/P156i_is_occupied_by",
				"http://www.cidoc-crm.org/cidoc-crm/P157_is_at_rest_relative_to",
				"http://www.cidoc-crm.org/cidoc-crm/P157i_provides_reference_space_for",
				"http://www.cidoc-crm.org/cidoc-crm/P160_has_temporal_projection",
				"http://www.cidoc-crm.org/cidoc-crm/P160i_is_temporal_projection_of",
				"http://www.cidoc-crm.org/cidoc-crm/P161_has_spatial_projection",
				"http://www.cidoc-crm.org/cidoc-crm/P161i_is_spatial_projection_of",
				"http://www.cidoc-crm.org/cidoc-crm/P164_during",
				"http://www.cidoc-crm.org/cidoc-crm/P164i_was_time-span_of",
				"http://www.cidoc-crm.org/cidoc-crm/P165_incorporates",
				"http://www.cidoc-crm.org/cidoc-crm/P165i_is_incorporated_in",
				"http://www.cidoc-crm.org/cidoc-crm/P166_was_a_presence_of",
				"http://www.cidoc-crm.org/cidoc-crm/P166i_had_presence", "http://www.cidoc-crm.org/cidoc-crm/P167_at",
				"http://www.cidoc-crm.org/cidoc-crm/P167i_was_place_of",
				"http://www.cidoc-crm.org/cidoc-crm/P168_place_is_defined_by",
				"http://www.cidoc-crm.org/cidoc-crm/P169_defines_spacetime_volume",
				"http://www.cidoc-crm.org/cidoc-crm/P169i_spacetime_volume_is_defined_by",
				"http://www.cidoc-crm.org/cidoc-crm/P170_defines_time",
				"http://www.cidoc-crm.org/cidoc-crm/P170i_time_is_defined_by",
				"http://www.cidoc-crm.org/cidoc-crm/P171_at_some_place_within",
				"http://www.cidoc-crm.org/cidoc-crm/P172_contains",
				"http://www.cidoc-crm.org/cidoc-crm/P173_starts_before_or_with_theend_of",
				"http://www.cidoc-crm.org/cidoc-crm/P173i_ends_after_or_with_the_start_of",
				"http://www.cidoc-crm.org/cidoc-crm/P174_starts_before_the_end_of",
				"http://www.cidoc-crm.org/cidoc-crm/P174i_ends_after_the_start_of",
				"http://www.cidoc-crm.org/cidoc-crm/P175_starts_before_or_with_the_start_of",
				"http://www.cidoc-crm.org/cidoc-crm/P175i_starts_after_or_with_the_start_of",
				"http://www.cidoc-crm.org/cidoc-crm/P176_starts_before_the_start_of",
				"http://www.cidoc-crm.org/cidoc-crm/P176i_starts_after_the_start_of",
				"http://www.cidoc-crm.org/cidoc-crm/P177_assigned_property_type",
				"http://www.cidoc-crm.org/cidoc-crm/P179_had_sales_price",
				"http://www.cidoc-crm.org/cidoc-crm/P179i_was_sales_price_of",
				"http://www.cidoc-crm.org/cidoc-crm/P180_has_currency",
				"http://www.cidoc-crm.org/cidoc-crm/P180i_was_currency_of",
				"http://www.cidoc-crm.org/cidoc-crm/P181_has_amount",
				"http://www.cidoc-crm.org/cidoc-crm/P182_ends_before_or_with_the_start_of",
				"http://www.cidoc-crm.org/cidoc-crm/P182i_starts_after_or_with_the_end_of",
				"http://www.cidoc-crm.org/cidoc-crm/P183_ends_beforethe_start_of",
				"http://www.cidoc-crm.org/cidoc-crm/P183i_starts_after_the_end_of",
				"http://www.cidoc-crm.org/cidoc-crm/P184_ends_before_or_with_the_end_of",
				"http://www.cidoc-crm.org/cidoc-crm/P184i_ends_with_or_afterthe_end_of",
				"http://www.cidoc-crm.org/cidoc-crm/P185_ends_before_the_end_of",
				"http://www.cidoc-crm.org/cidoc-crm/P185i_ends_afterthe_end_of",
				"http://www.cidoc-crm.org/cidoc-crm/P186_produced_thing_of_product_type",
				"http://www.cidoc-crm.org/cidoc-crm/P186i_is_produced_by",
				"http://www.cidoc-crm.org/cidoc-crm/P187_has_production_plan",
				"http://www.cidoc-crm.org/cidoc-crm/P187i_is_production_plan_for",
				"http://www.cidoc-crm.org/cidoc-crm/P188_requires_production_tool",
				"http://www.cidoc-crm.org/cidoc-crm/P188i_is_production_tool_for",
				"http://www.cidoc-crm.org/cidoc-crm/P189_approximates",
				"http://www.cidoc-crm.org/cidoc-crm/P189i_is_approximated_by",
				"http://www.cidoc-crm.org/cidoc-crm/P190_has_symbolic_content",
				"http://www.cidoc-crm.org/cidoc-crm/P191_had_duration",
				"http://www.cidoc-crm.org/cidoc-crm/P191i_was_duration_of");
	}
}
