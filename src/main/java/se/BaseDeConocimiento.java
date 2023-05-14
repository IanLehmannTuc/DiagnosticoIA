package se;

import com.github.cschen1205.ess.engine.EqualsClause;
import com.github.cschen1205.ess.engine.KieRuleInferenceEngine;
import com.github.cschen1205.ess.engine.NegationClause;
import com.github.cschen1205.ess.engine.Rule;
import com.github.cschen1205.ess.engine.RuleInferenceEngine;

public class BaseDeConocimiento {
    
    public static RuleInferenceEngine getRules(boolean showRules) {
        RuleInferenceEngine rie = new KieRuleInferenceEngine();

        problemaMemoriaRam(rie);
        problemaDiscoDuro(rie);
        problemaPlacaMother(rie);

        if (showRules) {
            System.out.println("Reglas:");
            System.out.println("------");
            rie.getRules().forEach((r) -> {
                System.out.println(r.toString());
            });
            System.out.println("===============================");
        }

        return rie;
    }
    
    private static void diagnosticoDengue(RuleInferenceEngine rie){
        
        Rule rule = new Rule("DENGUE_Regla_1");
        rule.addAntecedent(new EqualsClause(Hechos.fiebre, "si"));
        rule.addAntecedent(new EqualsClause(Hechos.dolorCabeza, "si"));
        rule.addAntecedent(new EqualsClause(Hechos.dolorOjos, "si"));
        rule.setConsequent(new EqualsClause(Hechos.dengue, "si"));
        rie.addRule(rule);
        
        Rule rule = new Rule("DENGUE_Regla_2");
        rule.setConsequent(new EqualsClause(Hechos.fiebre, "si"));
        rule.setConsequent(new EqualsClause(Hechos.dolorArticular, "si"));
        rule.setConsequent(new EqualsClause(Hechos.dolorMuscular, "si"));
        rule.setConsequent(new EqualsClause(Hechos.sarpullido, "si"));
        rule.setConsequent(new EqualsClause(Hechos.dengue, "si"));
        rie.addRule(rule);
        
        Rule rule = new Rule("DENGUE_Regla_3");
        rule.addAntecedent(new EqualsClause(Hechos.nauseas, "si"));
        rule.addAntecedent(new EqualsClause(Hechos.vomito, "si"));
        rule.addAntecedent(new EqualsClause(Hechos.dolorAbdominal, "si"));
        rule.addAntecedent(new OrClause(
                new EqualsClause(Hechos.sangradoEncias, "si"),
                new EqualsClause(Hechos.sangradoNariz, "si"),
                new EqualsClause(Hechos.sangradoPiel, "si")
        ));
        rule.setConsequent(new EqualsClause(Hechos.dengue, "si"));
        rie.addRule(rule);
        
        Rule rule = new Rule("DENGUE_Regla_4");
        rule.addAntecedent(new EqualsClause(Hechos.zonaRiesgo, "si"));
        rule.addAntecedent(new EqualsClause(Hechos.fiebre, "si"));
        rule.addAntecedent(new EqualsClause(Hechos.dolorOjos, "si"));
        rule.addAntecedent(new EqualsClause(Hechos.dolorMuscular, "si"));
        rule.setConsequent(new EqualsClause(Hechos.dengue, "si"));
        rie.addRule(rule);
        
        Rule rule = new Rule("DENGUE_Regla_5");
        rule.addAntecedent(new EqualsClause(Hechos.dolorOjos, "si"));
        rule.addAntecedent(new EqualsClause(Hechos.erupcionCutanea, "si"));
        rule.addAntecedent(new EqualsClause(Hechos.fiebre, "si"));
        rule.setConsequent(new EqualsClause(Hechos.dengue, "si"));
        rie.addRule(rule);
        
        Rule rule = new Rule("DENGUE_Regla_6");
        rule.addAntecedent(new EqualsClause(Hechos.dolorMuscular, "si"));
        rule.addAntecedent(new EqualsClause(Hechos.fatiga, "si"));
        rule.addAntecedent(new EqualsClause(Hechos.sangradoNariz, "si"));
        rule.setConsequent(new EqualsClause(Hechos.dengue, "si"));
        rie.addRule(rule);
        
        Rule rule = new Rule("DENGUE_Regla_7");
        rule.addAntecedent(new EqualsClause(Hechos.nauseas, "si"));
        rule.addAntecedent(new EqualsClause(Hechos.vomito, "si"));
        rule.addAntecedent(new EqualsClause(Hechos.dolorAbdominal, "si"));
        rule.addAntecedent(new EqualsClause(Hechos.sangradoPiel, "si"));
        rule.setConsequent(new EqualsClause(Hechos.dengue, "si"));
        rie.addRule(rule);
        
        Rule rule = new Rule("DENGUE_Regla_8");
        rule.addAntecedent(new EqualsClause(Hechos.zonaRiesgo, "si"));
        rule.addAntecedent(new EqualsClause(Hechos.fiebre, "si"));
        rule.addAntecedent(new EqualsClause(Hechos.dolorArticular, "si"));
        rule.addAntecedent(new EqualsClause(Hechos.debilidadGeneralziada, "si"));
        rule.setConsequent(new EqualsClause(Hechos.dengue, "si"));
        rie.addRule(rule);
        
        Rule rule = new Rule("DENGUE_Regla_9");
        rule.addAntecedent(new EqualsClause(Hechos.fiebre, "si"));
        rule.addAntecedent(new EqualsClause(Hechos.dolorCabeza, "si"));
        rule.addAntecedent(new EqualsClause(Hechos.dolorOjos, "si"));
        rule.addAntecedent(new EqualsClause(Hechos.erupcionCutanea, "si"));
        rule.setConsequent(new EqualsClause(Hechos.dengue, "si"));
        rie.addRule(rule);
        
        Rule rule = new Rule("DENGUE_Regla_10");
        rule.addAntecedent(new EqualsClause(Hechos.dolorMuscular, "si"));
        rule.addAntecedent(new EqualsClause(Hechos.dolorArticular, "si"));
        rule.addAntecedent(new EqualsClause(Hechos.fatiga, "si"));
        rule.addAntecedent(new OrClause(
                new EqualsClause(Hechos.sangradoEncias, "si"),
                new EqualsClause(Hechos.sangradoNariz, "si")
        ));
        rule.setConsequent(new EqualsClause(Hechos.dengue, "si"));
        rie.addRule(rule);
        
        Rule rule = new Rule("DENGUE_Regla_11");
        rule.addAntecedent(new EqualsClause(Hechos.nauseas, "si"));
        rule.addAntecedent(new EqualsClause(Hechos.vomito, "si"));
        rule.addAntecedent(new EqualsClause(Hechos.dolorAbdominal, "si"));
        rule.addAntecedent(new EqualsClause(Hechos.sangradoPiel, "si"));
        rule.setConsequent(new EqualsClause(Hechos.dengue, "si"));
        rie.addRule(rule);
        
        Rule rule = new Rule("DENGUE_Regla_12");
        rule.addAntecedent(new EqualsClause(Hechos.zonaRiesgo, "si"));
        rule.addAntecedent(new EqualsClause(Hechos.fiebre, "si"));
        rule.addAntecedent(new EqualsClause(Hechos.dolorOjos, "si"));
        rule.addAntecedent(new EqualsClause(Hechos.dolorArticular, "si"));
        rule.setConsequent(new EqualsClause(Hechos.dengue, "si"));
        rie.addRule(rule);
        
        Rule rule = new Rule("DENGUE_Regla_13");
        rule.addAntecedent(new EqualsClause(Hechos.dolorMuscular, "si"));
        rule.addAntecedent(new EqualsClause(Hechos.fatiga, "si"));
        rule.addAntecedent(new EqualsClause(Hechos.nauseas, "si"));
        rule.addAntecedent(new EqualsClause(Hechos.vomito, "si"));
        rule.setConsequent(new EqualsClause(Hechos.dengue, "si"));
        rie.addRule(rule);
        
        Rule rule = new Rule("DENGUE_Regla_14");
        rule.addAntecedent(new EqualsClause(Hechos.dolorAbdominal, "si"));
        rule.addAntecedent(new EqualsClause(Hechos.sangradoEncias, "si"));
        rule.addAntecedent(new EqualsClause(Hechos.sangradoNariz, "si"));
        rule.addAntecedent(new EqualsClause(Hechos.sangradoPiel, "si"));
        rule.setConsequent(new EqualsClause(Hechos.dengue, "si"));
        rie.addRule(rule);
        
        Rule rule = new Rule("DENGUE_Regla_15");
        rule.addAntecedent(new EqualsClause(Hechos.zonaRiesgo, "si"));
        rule.addAntecedent(new EqualsClause(Hechos.fiebre, "si"));
        rule.addAntecedent(new EqualsClause(Hechos.dolorOjos, "si"));
        rule.addAntecedent(new EqualsClause(Hechos.dolorArticular, "si"));
        rule.addAntecedent(new EqualsClause(Hechos.debilidadGeneralziada, "si"));
        rule.setConsequent(new EqualsClause(Hechos.dengue, "si"));
        rie.addRule(rule);
        
    }
    
    private static void diagnosticoCOVID(RuleInferenceEngine rie){
        
    }
}
